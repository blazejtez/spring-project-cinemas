package pl.edu.pg.menu.caffemenu.function;

import pl.edu.pg.menu.caffemenu.dto.MenusReadDTO;
import pl.edu.pg.menu.caffemenu.entity.Menu;

import java.util.List;
import java.util.function.Function;

public class MenuToMenusReadDTO implements Function<List<Menu>, MenusReadDTO> {
    @Override
    public MenusReadDTO apply(List<Menu> entities) {
        return MenusReadDTO.builder()
                .menus(entities.stream()
                        .map( menu -> MenusReadDTO.Menu.builder()
                                .id(menu.getId())
                                .name(menu.getName())
                                .build())
                        .toList())
                .build();
    }
}
