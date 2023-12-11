package pl.edu.pg.menu.cinemashowtimes.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pg.menu.cinemashowtimes.dto.CinemaReadDTO;
import pl.edu.pg.menu.cinemashowtimes.dto.CinemasReadDTO;
import pl.edu.pg.menu.cinemashowtimes.entity.Cinema;
import pl.edu.pg.menu.cinemashowtimes.function.MenuToDeleteMenuDTO;
import pl.edu.pg.menu.cinemashowtimes.function.MenuToMenuReadDTO;
import pl.edu.pg.menu.cinemashowtimes.function.MenuToMenuUpdateDTO;
import pl.edu.pg.menu.cinemashowtimes.function.MenuToMenusReadDTO;
import pl.edu.pg.menu.cinemashowtimes.service.CinemaService;

import java.util.List;
import java.util.UUID;
@RestController
public class CinemaController {
    private final CinemaService cinemaService;
    private final MenuToMenusReadDTO MenusToMenusReadDTO;
    private final MenuToDeleteMenuDTO MenuToDeleteMenuDTO;
    private final MenuToMenuReadDTO MenuToMenuReadDTO;
    private final MenuToMenuUpdateDTO MenuToMenuUpdateDTO;

    @Autowired
    public CinemaController(CinemaService cinemaService, MenuToMenusReadDTO menusToMenusReadDTO, pl.edu.pg.menu.cinemashowtimes.function.MenuToDeleteMenuDTO menuToDeleteMenuDTO, pl.edu.pg.menu.cinemashowtimes.function.MenuToMenuReadDTO menuToMenuReadDTO, pl.edu.pg.menu.cinemashowtimes.function.MenuToMenuUpdateDTO menuToMenuUpdateDTO) {
        this.cinemaService = cinemaService;
        MenusToMenusReadDTO = menusToMenusReadDTO;
        MenuToDeleteMenuDTO = menuToDeleteMenuDTO;
        MenuToMenuReadDTO = menuToMenuReadDTO;
        MenuToMenuUpdateDTO = menuToMenuUpdateDTO;
    }

    @GetMapping("api/menus")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    ResponseEntity<CinemasReadDTO> getMenus()
    {
        List<Cinema> cinemas = this.cinemaService.findAll();
        CinemasReadDTO cinemasReadDTO = this.MenusToMenusReadDTO.apply(cinemas);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "DishController");
        return ResponseEntity.accepted().headers(headers).body(cinemasReadDTO);
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
            Cinema cinema = this.cinemaService.findById(uuid);
            this.cinemaService.deleteById(uuid);
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
    ResponseEntity<CinemaReadDTO> getMenu(@PathVariable UUID uuid)
    {
        Cinema cinema = this.cinemaService.findById(uuid);
        CinemaReadDTO cinemaReadDTO = CinemaReadDTO
                .builder()
                .name(cinema.getName())
                .endDate(cinema.getEndDate())
                .startDate(cinema.getStartDate())
                .build();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "DishController");
        return ResponseEntity.accepted().headers(headers).body(cinemaReadDTO);
    }

}
