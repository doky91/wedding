package com.weddingplanner.controller;

import com.weddingplanner.entity.Offer;
import com.weddingplanner.response.ErrorResponse;
import com.weddingplanner.services.interfaces.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/offer")
@RequiredArgsConstructor
public class OfferController {

    private final OfferService offerService;

    @GetMapping
    public ResponseEntity<Object> getAllOffers() {
        return ResponseEntity.ok().body(offerService.findAllOffers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOfferById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(offerService.getOffer(id));
    }

    @PostMapping
    public ResponseEntity<Object> createOffer(@RequestBody Offer offer) {
        try {
            return ResponseEntity.ok(offerService.createOffer(offer));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Not good data",
                    "You didn't provide accurate data."));
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<Object> updateOffer(
            @PathVariable(value = "id") Long id,
            @RequestBody Offer offer) {
        return ResponseEntity.ok(offerService.updateOffer(id, offer));
    }

    @DeleteMapping("/{id}")
    public void deleteOffer(
            @PathVariable(value = "id") Long id) {
        offerService.deleteOffer(id);
    }
}
