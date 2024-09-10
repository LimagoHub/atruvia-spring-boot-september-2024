package de.atruvia.webapp.domain.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter(AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Schwein {

    private UUID id;
    private String name;
    private int gewicht;

    public void fuettern() {
        setGewicht(getGewicht() + 1);
    }
}
