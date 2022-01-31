package com.weddingplanner.repositories;

import com.weddingplanner.entity.OfferPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferPackageRepository extends JpaRepository<OfferPackage, Integer> {
}
