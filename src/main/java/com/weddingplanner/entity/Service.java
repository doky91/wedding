package com.weddingplanner.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "service")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @Basic
    @Column(name = "picture_url")
    private String pictureUrl;

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
}
