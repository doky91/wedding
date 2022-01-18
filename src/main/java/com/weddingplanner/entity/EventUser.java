package com.weddingplanner.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "event_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_role_id", referencedColumnName = "id")
    private UserEventRole userEventRole;
}
