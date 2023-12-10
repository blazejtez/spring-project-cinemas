package pl.edu.pg.menu.caffemenu.dto;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import pl.edu.pg.menu.caffemenu.entity.Showtime;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
@EqualsAndHashCode
public class DishDTO implements Comparable<Showtime> {
    @Id
    private UUID id;

    private String name;

    private BigDecimal price;

    private String menuName;

    public static DishDTO fromEntity(Showtime showtime)
    {
        DishDTO dishDTO = new DishDTO();
        dishDTO.setId(showtime.getId());
        dishDTO.setName(showtime.getName());
        dishDTO.setPrice(showtime.getPrice());
        dishDTO.setMenuName(showtime.getCinema().getName());
        return dishDTO;
    }

    public DishDTO() {

    }

    @Override
    public int compareTo(Showtime o) {
        return this.price.compareTo(o.getPrice());
    }

    @Override
    public String toString() {
        return "Dish [id=" + id + ", name=" + name + ", price=" + price + "]";
    }


}
