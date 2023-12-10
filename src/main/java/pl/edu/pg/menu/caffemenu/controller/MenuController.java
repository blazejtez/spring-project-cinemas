package pl.edu.pg.menu.caffemenu.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pg.menu.caffemenu.dto.MenuReadDTO;
import pl.edu.pg.menu.caffemenu.dto.MenusReadDTO;
import pl.edu.pg.menu.caffemenu.entity.Cinema;
import pl.edu.pg.menu.caffemenu.function.MenuToDeleteMenuDTO;
import pl.edu.pg.menu.caffemenu.function.MenuToMenuReadDTO;
import pl.edu.pg.menu.caffemenu.function.MenuToMenuUpdateDTO;
import pl.edu.pg.menu.caffemenu.function.MenuToMenusReadDTO;
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

    @Autowired
    public MenuController(MenuService menuService, MenuToMenusReadDTO menusToMenusReadDTO, pl.edu.pg.menu.caffemenu.function.MenuToDeleteMenuDTO menuToDeleteMenuDTO, pl.edu.pg.menu.caffemenu.function.MenuToMenuReadDTO menuToMenuReadDTO, pl.edu.pg.menu.caffemenu.function.MenuToMenuUpdateDTO menuToMenuUpdateDTO) {
        this.menuService = menuService;
        MenusToMenusReadDTO = menusToMenusReadDTO;
        MenuToDeleteMenuDTO = menuToDeleteMenuDTO;
        MenuToMenuReadDTO = menuToMenuReadDTO;
        MenuToMenuUpdateDTO = menuToMenuUpdateDTO;
    }

    @GetMapping("api/menus")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    ResponseEntity<MenusReadDTO> getMenus()
    {
        List<Cinema> cinemas = this.menuService.findAll();
        MenusReadDTO menusReadDTO = this.MenusToMenusReadDTO.apply(cinemas);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "DishController");
        return ResponseEntity.accepted().headers(headers).body(menusReadDTO);
    }
//
//    @PostMapping("api/menus")
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    ResponseEntity<String> postMenus(@RequestBody MenuUpdateDTO menuUpdateDTO)
//    {
//
//    }

    @DeleteMapping("api/menus/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    ResponseEntity<String> deleteMenu(@PathVariable UUID uuid)
    {
        try
        {
            Cinema cinema = this.menuService.findById(uuid);
            this.menuService.deleteById(uuid);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "DishController");
            return ResponseEntity.accepted().headers(headers).body("Succesfully deleted "+ uuid.toString());
        }
        catch (EntityNotFoundException e)
        {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Not Found", "DishController");
            return ResponseEntity.accepted().headers(headers).body("Entity with id: " + uuid.toString() + "was not found.");
        }


    }
    @GetMapping("api/menus/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    ResponseEntity<MenuReadDTO> getMenu(@PathVariable UUID uuid)
    {
        Cinema cinema = this.menuService.findById(uuid);
        MenuReadDTO menuReadDTO = MenuReadDTO
                .builder()
                .name(cinema.getName())
                .endDate(cinema.getEndDate())
                .startDate(cinema.getStartDate())
                .build();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "DishController");
        return ResponseEntity.accepted().headers(headers).body(menuReadDTO);
    }

}
