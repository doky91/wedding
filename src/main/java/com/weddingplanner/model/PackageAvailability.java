package com.weddingplanner.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PackageAvailability {

    private Long id;
    private OfferPackage offerPackage;
    private LocalDateTime availableFrom;
    private LocalDateTime availableTo;
    /*how many clients can service take on one day */
    private Integer availableOnDay;
}
