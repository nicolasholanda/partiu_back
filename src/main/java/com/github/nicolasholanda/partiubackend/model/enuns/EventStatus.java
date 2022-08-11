package com.github.nicolasholanda.partiubackend.model.enuns;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.OBJECT;
import static java.lang.String.format;

@Getter
@RequiredArgsConstructor
@JsonFormat(shape = OBJECT)
public enum EventStatus {

    WAITING_PARTICIPANTS("AGUARDANDO PESSOAS"),
    CONFIRMED("CONFIRMADO"),
    CANCELED("CANCELADO"),
    HAPPENING("ACONTECENDO"),
    FINISHED("FINALIZADO");

    @JsonProperty
    private final String description;

    @JsonCreator
    public static EventStatus fromJsonNode(final JsonNode jsonNode) {
        return fromString(Optional.of(jsonNode.get("codigo").asText()).orElse(jsonNode.asText()));
    }

    public static EventStatus fromString(String description) {
        return Stream.of(values()).filter(c -> c.description.equals(description)).findFirst().orElseThrow(() -> {
            throw new IllegalArgumentException(format("'%s' não corresponde a um status válido. Opções disponíveis: %s.",
                    description, Stream.of(values()).map(EventStatus::getDescription).collect(Collectors.joining(", "))));
        });
    }
}
