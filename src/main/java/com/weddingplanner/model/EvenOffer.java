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
public class EvenOffer {

    private Long id;
    private Event event;
    private Offer offer;
    private Boolean selected;
}
