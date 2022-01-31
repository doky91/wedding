package com.weddingplanner.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "offer_package")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OfferPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "offer_id", referencedColumnName = "id", nullable = false)
    private Offer offer;

    @Basic
    @Column
    private String name;

    @Basic
    @Column
    private String description;

    @Basic
    @Column
    private Float price;

    @ManyToOne
    @JoinColumn(name = "price_currency_id", referencedColumnName = "id", nullable = false)
    private Currency currency;

}
