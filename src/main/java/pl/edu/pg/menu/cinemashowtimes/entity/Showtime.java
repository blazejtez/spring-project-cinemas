package pl.edu.pg.menu.cinemashowtimes.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;




@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "showtime")
@ToString
public class Showtime implements Comparable<Showtime>, Serializable {
    @Id
    private UUID id;

    private String name;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "cinema")
    private Cinema cinema;


    @Override
    public int compareTo(Showtime o) {
        return this.price.compareTo(o.getPrice());
    }


}
