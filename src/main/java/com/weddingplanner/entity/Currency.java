package com.weddingplanner.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "currency")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Basic
    @Column
    private String country;

    @Basic
    @Column
    private String shortId;

    @Basic
    @Column
    private Float rate;
}
