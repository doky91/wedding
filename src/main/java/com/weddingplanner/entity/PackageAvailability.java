package com.weddingplanner.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "package_availability")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PackageAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "service_package_id", referencedColumnName = "id")
    private OfferPackage offerPackage;

    @Basic
    @Column(name = "available_from")
    private LocalDateTime availableFrom;

    @Basic
    @Column(name = "available_to")
    private LocalDateTime availableTo;

    /*how many clients can service take on one day */
    @Basic
    @Column(name = "available_on_day")
    private Integer availableOnDay;
}
