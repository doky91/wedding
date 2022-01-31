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
public class EventUser {

    private Long id;
    private Event event;
    private User user;
    private UserEventRole userEventRole;
}
