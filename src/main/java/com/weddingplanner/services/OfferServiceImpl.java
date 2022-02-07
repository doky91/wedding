package com.weddingplanner.services;

import com.weddingplanner.entity.Category;
import com.weddingplanner.entity.Offer;
import com.weddingplanner.exceptions.DataFailedException;
import com.weddingplanner.repositories.CategoryRepository;
import com.weddingplanner.repositories.OfferRepository;
import com.weddingplanner.services.interfaces.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl extends BasicServiceOperations implements OfferService {

    private final OfferRepository offerRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Offer createOffer(Offer offer) {
        checkOffer(offer);
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
                                if (doesNameExist(input.getName()) || isDataInvalid(input.getName())) {
                                    throw new DataFailedException(
                                            CONFLICT, "Offer name:" + input.getName() +
                                            "was not provided or already exists.");
                                }
                                offer1.setName(input.getName());
                            }
                            checkOffer(offer1);
                            offer1.setCategory(checkCategory(input.getCategory()));
                            offer1.setContactPerson(input.getContactPerson());
                            offer1.setPictureUrl(input.getPictureUrl());
                            offer1.setDescription(input.getDescription());

                            offer1.setContactPhone(input.getContactPhone());
                            offer1.setContactEmail(input.getContactEmail());

                            return offer1;
                        })
                .orElseThrow(itemNotFound("Offer with id" + id + " does not exist"));
        return offerRepository.save(offer);
    }

    @Override
    public void deleteOffer(Long id) {
        offerRepository.findById(id)
                .orElseThrow(itemNotFound("Offer with id: " + id + " does not exist"));
        offerRepository.deleteById(id);
    }

    @Override
    public List<Offer> findAllOffers() {
        return offerRepository.findAll();
    }

    private boolean isDataInvalid(String data) {
        return data == null || data.isEmpty() || data.trim().isEmpty();
    }

    private void checkOffer(Offer offer) {
        if (doesNameExist(offer.getName()) || isDataInvalid(offer.getName())) {
            throw new DataFailedException(
                    CONFLICT, "Offer name:" + offer.getName() +
                    "was not provided or already exists.");
        }

        if (isDataInvalid(offer.getContactPerson()) || isDataInvalid(offer.getContactPhone())
                || isDataInvalid(offer.getContactEmail())) {
            throw new DataFailedException(
                    BAD_REQUEST, "You did not provide all contact information:");
        }

        if (isDataInvalid(offer.getPictureUrl())) {
            throw new DataFailedException(
                    BAD_REQUEST, "You did not provide picture url:");
        }

        if (isDataInvalid(offer.getDescription())) {
            throw new DataFailedException(
                    BAD_REQUEST, "You did not provide description:");
        }

        offer.setCategory(checkCategory(offer.getCategory()));
    }

    private Category checkCategory(Category category) {
        if (category.getName() != null) {
            Optional<Category> categoryFromDb = categoryRepository.findCategoryByName(category.getName());
            if (!categoryFromDb.isPresent()) {
                categoryRepository.save(category);
            }
        }
        if (category.getId() != null) {
            return categoryRepository.getById(category.getId());
        }
        return category;
    }

    private boolean doesNameExist(String name) {
        Optional<Offer> offer = offerRepository.findOfferByName(name);
        return offer.isPresent();
    }

}
