package com.weddingplanner.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "service_package")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServicePackage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic
    @Column
    private Service service;

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
