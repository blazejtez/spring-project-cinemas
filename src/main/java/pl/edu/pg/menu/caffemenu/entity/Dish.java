package pl.edu.pg.menu.caffemenu.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Dish implements Comparable<Dish>, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal price;

    @ManyToOne
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
