package pl.edu.pg.menu.caffemenu.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.menu.caffemenu.dto.MenusReadDTO;
import pl.edu.pg.menu.caffemenu.entity.Cinema;

import java.util.List;
import java.util.function.Function;
@Component
public class MenuToMenusReadDTO implements Function<List<Cinema>, MenusReadDTO> {
    @Override
    public MenusReadDTO apply(List<Cinema> entities) {
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
