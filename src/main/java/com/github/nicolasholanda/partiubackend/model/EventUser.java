package com.github.nicolasholanda.partiubackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Data
@Table
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EventUser {

    @EmbeddedId
    private EventUserId id;

    @JsonProperty
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("eventId")
    private Event event;

    @JsonProperty
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate = now();

    @JsonProperty
    @Column(name = "paid", nullable = false)
    private boolean paid = false;
}
