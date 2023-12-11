package pl.edu.pg.cinema.cinemashowtimes.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pg.cinema.cinemashowtimes.dto.CinemaCreateDTO;
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
    private final CinemasToCinemasReadDTO cinemasToCinemasReadDTO;
    private final CinemaToCinemaReadDTO cinemaToCinemaReadDTO;
    private final CinemaToCinemaCreateDTO cinemaToCinemaCreateDTO;

    @Autowired
    public CinemaController(CinemaService cinemaService,
                            CinemasToCinemasReadDTO cinemasToCinemasReadDTO,
                            CinemaToCinemaReadDTO cinemaToCinemaReadDTO,
                            CinemaToCinemaCreateDTO cinemaToCinemaCreateDTO) {
        this.cinemaService = cinemaService;
        this.cinemasToCinemasReadDTO = cinemasToCinemasReadDTO;
        this.cinemaToCinemaReadDTO = cinemaToCinemaReadDTO;
        this.cinemaToCinemaCreateDTO = cinemaToCinemaCreateDTO;
    }


    @GetMapping("api/cinemas")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    ResponseEntity<CinemasReadDTO> getCinemas()
    {
        List<Cinema> cinemas = this.cinemaService.findAll();
        CinemasReadDTO cinemasReadDTO = this.cinemasToCinemasReadDTO.apply(cinemas);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "CinemaController");
        return ResponseEntity.accepted().headers(headers).body(cinemasReadDTO);
    }

    @PostMapping("api/cinemas/api/cinemas")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    ResponseEntity<String> postCinema(@RequestBody CinemaCreateDTO cinemaCreateDTO)
    {
        this.cinemaService.create(cinemaCreateDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "CinemasController");
        return ResponseEntity.accepted().headers(headers).body("Successfully created");
    }

    @DeleteMapping("api/cinemas/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    ResponseEntity<String> deleteCinema(@PathVariable UUID uuid)
    {
        try
        {
            Cinema cinema = this.cinemaService.findById(uuid);
            this.cinemaService.deleteById(uuid);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "CinemaController");
            return ResponseEntity.accepted().headers(headers).body("Succesfully deleted "+ uuid.toString());
        }
        catch (EntityNotFoundException e)
        {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Not Found", "CinemaController");
            return ResponseEntity.notFound().headers(headers).build();
        }


    }
    @GetMapping("api/cinemas/{uuid}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    ResponseEntity<CinemaReadDTO> getCinema(@PathVariable UUID uuid)
    {
        try
        {
            Cinema cinema = this.cinemaService.findById(uuid);
            CinemaReadDTO cinemaReadDTO = cinemaToCinemaReadDTO.apply(cinema);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "CinemaController");
            return ResponseEntity.accepted().headers(headers).body(cinemaReadDTO);
        }
        catch (EntityNotFoundException e) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "CinemaController");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).build();
        }

    }


}
