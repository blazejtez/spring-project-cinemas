package pl.edu.pg.menu.caffemenu.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany
    private List<Dish> dishes;
    public void addDish(Dish dish) {
        this.dishes.add(dish);
    }
}
