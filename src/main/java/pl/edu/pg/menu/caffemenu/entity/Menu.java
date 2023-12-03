package pl.edu.pg.menu.caffemenu.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "menus")
public class Menu implements Comparable<Menu>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;

    @OneToMany(mappedBy = "menu")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
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
