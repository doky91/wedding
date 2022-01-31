package com.weddingplanner.services.interfaces;

import com.weddingplanner.entity.Offer;
import com.weddingplanner.exceptions.DataFailedException;
import com.weddingplanner.repositories.OfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CONFLICT;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl extends BasicServiceOperations implements OfferService {

    private final OfferRepository offerRepository;

    @Override
    public Offer createOffer(Offer offer) {
        if (doesNameExist(offer.getName())) {
            throw new DataFailedException(
                    CONFLICT, "Offer name:" + offer.getName() + "already exists in database.");
        }
        return offerRepository.save(offer);
    }

    @Override
    public Offer getOffer(Long id) {
        return offerRepository
                .findById(id)
                .orElseThrow(itemNotFound("Offer with id: " + id + " was not found."));
    }

    @Override
    @Transactional
    public Offer updateOffer(Long id, Offer input) {
        Offer offer = offerRepository
                .findById(id)
                .map(
                        offer1 -> {
                            if (!offer1.getName().equals(input.getName())) {
                                if (doesNameExist(input.getName())) {
                                    throw new DataFailedException(
                                            CONFLICT, "Offer name:" + input.getName() + "already exists in database.");
                                }
                                offer1.setName(input.getName());
                            }

                            offer1.setCategory(input.getCategory());
                            offer1.setPictureUrl(input.getPictureUrl());
                            offer1.setDescription(input.getDescription());
                            offer1.setContactPerson(input.getContactPerson());
                            offer1.setContactPhone(input.getContactPhone());
                            offer1.setContactEmail(input.getContactEmail());

                            return offer1;
                        })
                .orElseThrow(itemNotFound("Offer with id" + id + " does not exist"));
        return offerRepository.save(offer);
    }

    @Override
    public void deleteOffer(Long id) {
        offerRepository.deleteById(id);
    }


    private boolean doesNameExist(String name) {
        Optional<Offer> offer = offerRepository.findOfferByName(name);
        return offer.isPresent();
    }
}
