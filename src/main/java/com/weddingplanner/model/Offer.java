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
public class Offer {

    private Long id;

    private Category category;

    private String pictureUrl;

    private String name;

    private String description;

    private String contactPerson;

    private String contactPhone;

    private String contactEmail;
}
