package pl.edu.pg.menu.caffemenu.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.menu.caffemenu.dto.DeleteDishDTO;
import pl.edu.pg.menu.caffemenu.dto.DishesReadDTO;
import pl.edu.pg.menu.caffemenu.entity.Dish;

import java.util.List;
import java.util.function.Function;
@Component
public class DishToDeleteDishDTO  implements Function<Dish, DeleteDishDTO> {
    @Override
    public DeleteDishDTO apply(Dish entity) {
        return DeleteDishDTO.builder().build();
    }
}
