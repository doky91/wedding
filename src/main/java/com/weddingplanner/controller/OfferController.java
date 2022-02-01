package com.weddingplanner.controller;

import com.weddingplanner.entity.Offer;
import com.weddingplanner.services.interfaces.OfferService;
import lombok.RequiredArgsConstructor;
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
        return ResponseEntity.ok(offerService.createOffer(offer));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Object> updateCategory(
            @PathVariable(value = "id") Long id,
            @RequestBody Offer offer) {
        return ResponseEntity.ok(offerService.updateOffer(id, offer));
    }

    @DeleteMapping("/{id}")
    public void updateCategory(
            @PathVariable(value = "id") Long id) {
        offerService.deleteOffer(id);
    }
}
