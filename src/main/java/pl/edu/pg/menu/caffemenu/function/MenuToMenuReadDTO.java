package pl.edu.pg.menu.caffemenu.function;

import pl.edu.pg.menu.caffemenu.dto.MenuReadDTO;
import pl.edu.pg.menu.caffemenu.entity.Menu;

import java.util.function.Function;

public class MenuToMenuReadDTO implements Function<Menu, MenuReadDTO> {

    @Override
    public MenuReadDTO apply(Menu entity) {
        return MenuReadDTO.builder()
                .name(entity.getName())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .build();
    }
}
