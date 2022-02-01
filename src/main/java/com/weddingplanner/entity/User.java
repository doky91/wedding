package com.weddingplanner.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    @Column
    private String username;

    @Basic
    @Column
    private String password;

    @Basic
    @Column
    private String email;

    @Basic
    @Column
    private Boolean active;

    @Basic
    @Column
    private String roles;
}
