package com.weddingplanner.services.interfaces;

import com.weddingplanner.entity.Offer;

import java.util.List;

public interface OfferService {

    List<Offer> findAllOffers();

    Offer getOffer(Long id);

    Offer createOffer(Offer offer);

    Offer updateOffer(Long id, Offer input);

    void deleteOffer(Long id);
}
