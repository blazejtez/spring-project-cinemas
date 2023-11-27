package pl.edu.pg.menu.caffemenu.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Menu implements Comparable<Menu> {

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
    @Override
    public String toString() {
        return "Menu [id=" + id + ", name=" + name + ", start date=" + startDate + ", end date=" + endDate + "]";

    }
    @Override
    public int compareTo(Menu o) {
        {
            return this.startDate.compareTo(o.getStartDate());
        }
    }
}
