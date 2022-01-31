package com.weddingplanner.repositories;

import com.weddingplanner.entity.PackageAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageAvailabilityRepository  extends JpaRepository<PackageAvailability, Integer> {
}
