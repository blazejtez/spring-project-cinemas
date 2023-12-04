package pl.edu.pg.menu.caffemenu.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pg.menu.caffemenu.dto.MenuReadDTO;
import pl.edu.pg.menu.caffemenu.dto.MenusReadDTO;
import pl.edu.pg.menu.caffemenu.entity.Dish;
import pl.edu.pg.menu.caffemenu.entity.Menu;
import pl.edu.pg.menu.caffemenu.function.MenuToDeleteMenuDTO;
import pl.edu.pg.menu.caffemenu.function.MenuToMenuReadDTO;
import pl.edu.pg.menu.caffemenu.function.MenuToMenuUpdateDTO;
import pl.edu.pg.menu.caffemenu.function.MenuToMenusReadDTO;
import pl.edu.pg.menu.caffemenu.function.MenusToMenusReadDTO;
import pl.edu.pg.menu.caffemenu.service.MenuService;
import pl.edu.pg.menu.caffemenu.service.MenuService;

import java.util.List;
import java.util.UUID;

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

    @PostMapping("api/menus")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    void postMenus()
    {

    }

    @DeleteMapping("api/menu/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    ResponseEntity<String> deleteMenu(@PathVariable UUID uuid)
    {
        Menu menu = this.menuService.findById(uuid);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "DishController");
        return ResponseEntity.accepted().headers(headers).body("Succesfully deleted "+ uuid.toString());
    }
    @GetMapping("api/menu/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    ResponseEntity<MenuReadDTO> getMenu(@PathVariable UUID uuid)
    {
        Menu menu = this.menuService.findById(uuid);
        MenuReadDTO menuReadDTO = MenuReadDTO
                .builder()
                .name(menu.getName())
                .endDate(menu.getEndDate())
                .startDate(menu.getStartDate())
                .build();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "DishController");
        return ResponseEntity.accepted().headers(headers).body(menuReadDTO);
    }

}
