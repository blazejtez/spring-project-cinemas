package pl.edu.pg.menu.caffemenu.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.menu.caffemenu.dto.DeleteMenuDTO;
import pl.edu.pg.menu.caffemenu.entity.Cinema;

import java.util.function.Function;
@Component
public class MenuToDeleteMenuDTO implements Function<Cinema, DeleteMenuDTO> {
    @Override
    public DeleteMenuDTO apply(Cinema entity) {
        return DeleteMenuDTO.builder().build();
    }
}
