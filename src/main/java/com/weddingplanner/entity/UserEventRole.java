package com.weddingplanner.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_event_role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEventRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic
    @Column
    private String name;
}
