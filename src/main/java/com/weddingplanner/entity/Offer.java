package com.weddingplanner.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "offer")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    @Column
    private String name;

    @Basic
    @Column
    private String description;

    @Basic
    @Column
    private String contactPerson;

    @Basic
    @Column
    private String contactPhone;

    @Basic
    @Column
    private String contactEmail;

    @Basic
    @Column(name = "picture_url")
    private String pictureUrl;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id",  referencedColumnName = "id")
    private Category category;

}
