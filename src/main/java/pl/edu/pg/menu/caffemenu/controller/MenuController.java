package pl.edu.pg.menu.caffemenu.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pg.menu.caffemenu.dto.MenusReadDTO;
import pl.edu.pg.menu.caffemenu.entity.Menu;
import pl.edu.pg.menu.caffemenu.service.MenuService;

import java.util.List;

@RestController
public class MenuController {
    private MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("api/menus")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    MenusReadDTO getMenus()
    {
        List<MenusReadDTO> menus = this.menuService.findAll().stream().map();

    }
}
