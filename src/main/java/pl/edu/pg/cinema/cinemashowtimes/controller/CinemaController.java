package pl.edu.pg.cinema.cinemashowtimes.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pg.cinema.cinemashowtimes.dto.CinemaReadDTO;
import pl.edu.pg.cinema.cinemashowtimes.dto.CinemasReadDTO;
import pl.edu.pg.cinema.cinemashowtimes.entity.Cinema;
import pl.edu.pg.cinema.cinemashowtimes.function.CinemaToCinemaReadDTO;
import pl.edu.pg.cinema.cinemashowtimes.function.CinemaToCinemaCreateDTO;
import pl.edu.pg.cinema.cinemashowtimes.function.CinemasToCinemasReadDTO;
import pl.edu.pg.cinema.cinemashowtimes.service.CinemaService;

import java.util.List;
import java.util.UUID;
@RestController
public class CinemaController {
    private final CinemaService cinemaService;
    private final CinemasToCinemasReadDTO MenusToMenusReadDTO;
    private final CinemaToCinemaReadDTO CinemaToCinemaReadDTO;
    private final CinemaToCinemaCreateDTO CinemaToCinemaCreateDTO;

    @Autowired
    public CinemaController(CinemaService cinemaService,
                            CinemasToCinemasReadDTO menusToMenusReadDTO,
                            CinemaToCinemaReadDTO cinemaToCinemaReadDTO,
                            CinemaToCinemaCreateDTO cinemaToCinemaCreateDTO) {
        this.cinemaService = cinemaService;
        MenusToMenusReadDTO = menusToMenusReadDTO;
        CinemaToCinemaReadDTO = cinemaToCinemaReadDTO;
        CinemaToCinemaCreateDTO = cinemaToCinemaCreateDTO;
    }

    @GetMapping("api/cinemas")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    ResponseEntity<CinemasReadDTO> getMenus()
    {
        List<Cinema> cinemas = this.cinemaService.findAll();
        CinemasReadDTO cinemasReadDTO = this.MenusToMenusReadDTO.apply(cinemas);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "CinemaController");
        return ResponseEntity.accepted().headers(headers).body(cinemasReadDTO);
    }
//
//    @PostMapping("api/cinemas")
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    ResponseEntity<String> postMenus(@RequestBody MenuUpdateDTO cinemaUpdateDTO)
//    {
//
//    }

    @DeleteMapping("api/cinemas/{uuid}")
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
    @GetMapping("api/cinemas/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    ResponseEntity<CinemaReadDTO> getMenu(@PathVariable UUID uuid)
    {
        Cinema cinema = this.cinemaService.findById(uuid);
        CinemaReadDTO cinemaReadDTO = CinemaReadDTO
                .builder()
                .name(cinema.getName())
                .build();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "DishController");
        return ResponseEntity.accepted().headers(headers).body(cinemaReadDTO);
    }

}
