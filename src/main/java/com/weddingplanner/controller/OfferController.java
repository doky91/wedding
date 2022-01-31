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

    @PostMapping("/create")
    public ResponseEntity<Object> createOffer(@RequestBody Offer offer) {

        return ResponseEntity.ok(offerService.createOffer(offer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOfferById(@PathVariable(value = "id") Long id) {

        return ResponseEntity.ok().body(offerService.getOffer(id));
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Object> updateCategory(
            @PathVariable(value = "id") Long id,
            @RequestBody Offer offer) {

        return ResponseEntity.ok(offerService.updateOffer(id, offer));
    }

    @PostMapping("/delete/{id}")
    public void updateCategory(
            @PathVariable(value = "id") Long id) {

        offerService.deleteOffer(id);
    }
}
