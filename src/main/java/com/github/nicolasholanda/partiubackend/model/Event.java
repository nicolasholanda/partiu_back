package com.github.nicolasholanda.partiubackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.nicolasholanda.partiubackend.model.enuns.EventStatus;
import lombok.*;
import org.keycloak.representations.idm.UserRepresentation;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;
import static java.time.LocalDateTime.now;
import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.EnumType.STRING;

@Data
@Table
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Event extends BaseEntity<Event> {

    @JsonProperty
    @NotNull(message = "{event.name.notnull}")
    @Column(name = "name", nullable = false)
    private String name;

    @JsonProperty
    @NotNull(message = "{event.price.notnull}")
    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @JsonProperty
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate = now();

    @JsonProperty
    @NotNull(message = "{event.initialDate.notnull}")
    @Column(name = "initial_date", nullable = false)
    private LocalDateTime initialDate;

    @JsonProperty
    @NotNull(message = "{event.initialFinal.notnull}")
    @Column(name = "final_date", nullable = false)
    private LocalDateTime finalDate;

    @JsonProperty
    @Column(name = "min_participants")
    private Integer minParticipants;

    @JsonProperty
    @Column(name = "max_participants")
    private Integer maxParticipants;

    @JsonProperty(access = READ_ONLY)
    @Enumerated(STRING)
    @Column(name = "status", nullable = false)
    private EventStatus status = EventStatus.WAITING_PARTICIPANTS;

    @JsonProperty
    @NotNull(message = "{event.creatorid.notnull}")
    @Column(name = "creator_id", nullable = false)
    private String creatorId;

    @OneToMany(mappedBy = "event", cascade = REMOVE, orphanRemoval = true)
    private List<EventUser> users;

    @ManyToOne
    @JsonProperty
    @NotNull(message = "{event.location.notnull}")
    @JoinColumn(name = "location_id", foreignKey = @ForeignKey(name = "fk_location"))
    private Location location;

    @Transient
    @JsonProperty
    private UserRepresentation creator;

    @Override
    public void update(Event updatedEvent) {
        this.status = updatedEvent.getStatus();
        this.location = updatedEvent.getLocation();
        this.finalDate = updatedEvent.getFinalDate();
        this.initialDate = updatedEvent.getInitialDate();
        this.maxParticipants = updatedEvent.getMaxParticipants();
        this.minParticipants = updatedEvent.getMinParticipants();
    }
}
