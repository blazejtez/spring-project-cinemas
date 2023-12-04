package pl.edu.pg.menu.caffemenu.function;

import pl.edu.pg.menu.caffemenu.dto.DeleteDishDTO;
import pl.edu.pg.menu.caffemenu.dto.DeleteMenuDTO;
import pl.edu.pg.menu.caffemenu.entity.Menu;

import java.util.function.Function;

public class MenuToDeleteMenuDTO implements Function<Menu, DeleteMenuDTO> {
    @Override
    public DeleteMenuDTO apply(Menu entity) {
        return DeleteMenuDTO.builder().build();
    }
}
