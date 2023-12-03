package pl.edu.pg.menu.caffemenu.entity;

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
@Table(name = "dishes")
@ToString
public class Dish implements Comparable<Dish>, Serializable {
    @Id
    private UUID id;

    private String name;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "menu")
    private Menu menu;


    @Override
    public int compareTo(Dish o) {
        return this.price.compareTo(o.getPrice());
    }


}
