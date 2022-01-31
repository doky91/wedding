package com.weddingplanner.repositories;

import com.weddingplanner.entity.EventOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventOfferRepository extends JpaRepository<EventOffer, Integer> {
}
