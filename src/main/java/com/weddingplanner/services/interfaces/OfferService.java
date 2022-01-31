package com.weddingplanner.services.interfaces;


import com.weddingplanner.entity.Offer;

public interface OfferService {

    Offer createOffer(Offer offer);

    Offer getOffer(Long id);

    Offer updateOffer(Long id, Offer input);

    void deleteOffer(Long id);
}
