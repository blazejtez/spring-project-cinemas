package pl.edu.pg.menu.caffemenu.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@EqualsAndHashCode
public class Dish implements Comparable<Dish>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal price;

    @ManyToOne
    private Menu menu;


    @Override
    public int compareTo(Dish o) {
        return this.price.compareTo(o.getPrice());
    }

    @Override
    public String toString() {
        return "Dish [id=" + id + ", name=" + name + ", price=" + price + "]";
    }

}
