package pl.edu.pg.menu.caffemenu.dto;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import pl.edu.pg.menu.caffemenu.entity.Dish;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@EqualsAndHashCode
public class DishDTO implements Comparable<Dish> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal price;

    private String menuName;

    public DishDTO fromEntity(Dish dish)
    {
        DishDTO dishDTO = new DishDTO();
        dishDTO.setId(dish.getId());
        dishDTO.setName(dish.getName());
        dishDTO.setPrice(dish.getPrice());
        dishDTO.setMenuName(dish.getMenu().getName());
        return dishDTO;
    }

    public DishDTO() {

    }

    @Override
    public int compareTo(Dish o) {
        return this.price.compareTo(o.getPrice());
    }

    @Override
    public String toString() {
        return "Dish [id=" + id + ", name=" + name + ", price=" + price + "]";
    }


}
