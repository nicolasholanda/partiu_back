package com.github.nicolasholanda.partiubackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class EventUserId implements Serializable {

    @Column(name = "user_id")
    private String userId;

    @Column(name = "event_id")
    private Long eventId;
}
