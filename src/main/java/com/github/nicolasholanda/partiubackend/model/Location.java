package com.github.nicolasholanda.partiubackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Table
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Location extends BaseEntity<Location> {

    @JsonProperty
    @Column(name = "name", nullable = false, unique = true)
    @NotNull(message = "{location.name.notnull}")
    private String name;

    @JsonProperty
    @Column(name = "latitude", nullable = false)
    @NotNull(message = "{location.latitude.notnull}")
    @Digits(integer = 2, fraction = 14, message = "{location.latitude.digits}")
    private BigDecimal latitude;

    @JsonProperty
    @Column(name = "longitude", nullable = false)
    @NotNull(message = "{location.longitude.notnull}")
    @Digits(integer = 3, fraction = 14, message = "{location.longitude.digits}")
    private BigDecimal longitude;

    @Override
    public void update(Location updatedLocation) {
        this.name = updatedLocation.getName();
        this.latitude = updatedLocation.getLatitude();
        this.longitude = updatedLocation.getLongitude();
    }
}
