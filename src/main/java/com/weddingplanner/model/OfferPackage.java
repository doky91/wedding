package com.weddingplanner.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OfferPackage {

    private Long id;
    private Offer offer;
    private String name;
    private String description;
    private Float price;
    private Currency currency;

}
