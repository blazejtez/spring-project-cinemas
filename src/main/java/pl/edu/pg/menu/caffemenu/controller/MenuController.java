package pl.edu.pg.menu.caffemenu.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pg.menu.caffemenu.dto.MenusReadDTO;
import pl.edu.pg.menu.caffemenu.entity.Menu;
import pl.edu.pg.menu.caffemenu.function.MenuToDeleteMenuDTO;
import pl.edu.pg.menu.caffemenu.function.MenuToMenuReadDTO;
import pl.edu.pg.menu.caffemenu.function.MenuToMenuUpdateDTO;
import pl.edu.pg.menu.caffemenu.function.MenuToMenusReadDTO;
import pl.edu.pg.menu.caffemenu.function.MenusToMenusReadDTO;
import pl.edu.pg.menu.caffemenu.service.MenuService;
import pl.edu.pg.menu.caffemenu.service.MenuService;

import java.util.List;

@RestController
public class MenuController {
    private final MenuService menuService;
    private final MenuToMenusReadDTO MenusToMenusReadDTO;
    private final MenuToDeleteMenuDTO MenuToDeleteMenuDTO;
    private final MenuToMenuReadDTO MenuToMenuReadDTO;
    private final MenuToMenuUpdateDTO MenuToMenuUpdateDTO;

    public MenuController(MenuService menuService,
                          MenuToMenusReadDTO menusToMenusReadDTO,
                          MenuToDeleteMenuDTO menuToDeleteMenuDTO,
                          MenuToMenuReadDTO menuToMenuReadDTO,
                          MenuToMenuUpdateDTO menuToMenuUpdateDTO) {
        this.menuService = menuService;
        MenusToMenusReadDTO = menusToMenusReadDTO;
        MenuToDeleteMenuDTO = menuToDeleteMenuDTO;
        MenuToMenuReadDTO = menuToMenuReadDTO;
        MenuToMenuUpdateDTO = menuToMenuUpdateDTO;
    }

    @GetMapping("api/menus")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    MenusReadDTO getMenus()
    {
        
    }
}
