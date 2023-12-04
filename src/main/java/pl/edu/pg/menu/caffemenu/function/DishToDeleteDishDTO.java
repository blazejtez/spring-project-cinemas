package pl.edu.pg.menu.caffemenu.function;

import pl.edu.pg.menu.caffemenu.dto.DeleteDishDTO;
import pl.edu.pg.menu.caffemenu.dto.DishesReadDTO;
import pl.edu.pg.menu.caffemenu.entity.Dish;

import java.util.List;
import java.util.function.Function;

public class DishToDeleteDishDTO  implements Function<List<Dish>, DeleteDishDTO> {
    @Override
    public DeleteDishDTO apply(List<Dish> entities) {
        return null;
    }
}
