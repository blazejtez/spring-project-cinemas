package pl.edu.pg.menu.caffemenu.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "dishes")
public class Dish implements Comparable<Dish>, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "menu")
    private transient Menu menu;


    @Override
    public int compareTo(Dish o) {
        return this.price.compareTo(o.getPrice());
    }

    @Override
    public String toString() {
        return "Dish [id=" + id + ", name=" + name + ", price=" + price + " from Menu: "+ menu.getName() + "]";
    }

}
