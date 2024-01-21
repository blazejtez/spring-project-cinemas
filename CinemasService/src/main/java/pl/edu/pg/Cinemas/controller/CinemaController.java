package pl.edu.pg.Cinemas.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pg.Cinemas.dto.CinemaCreateDTO;
import pl.edu.pg.Cinemas.dto.CinemaReadDTO;
import pl.edu.pg.Cinemas.dto.CinemasReadDTO;
import pl.edu.pg.Cinemas.entity.Cinema;
import pl.edu.pg.Cinemas.function.CinemaCreateDTOToCinema;
import pl.edu.pg.Cinemas.function.CinemaToCinemaReadDTO;
import pl.edu.pg.Cinemas.function.CinemasToCinemasReadDTO;
import pl.edu.pg.Cinemas.service.CinemaService;

import java.util.List;
import java.util.UUID;
@RestController
public class CinemaController {
    private final CinemaService cinemaService;
    private final CinemasToCinemasReadDTO cinemasToCinemasReadDTO;
    private final CinemaToCinemaReadDTO cinemaToCinemaReadDTO;
    private final CinemaCreateDTOToCinema cinemaCreateDTOToCinema;

    @Autowired
    public CinemaController(CinemaService cinemaService,
                            CinemasToCinemasReadDTO cinemasToCinemasReadDTO,
                            CinemaToCinemaReadDTO cinemaToCinemaReadDTO,
                            CinemaCreateDTOToCinema cinemaCreateDTOToCinema) {
        this.cinemaService = cinemaService;
        this.cinemasToCinemasReadDTO = cinemasToCinemasReadDTO;
        this.cinemaToCinemaReadDTO = cinemaToCinemaReadDTO;
        this.cinemaCreateDTOToCinema = cinemaCreateDTOToCinema;
    }

    // logic: the requests is always correct, no reason to throw Exceptions.
    @GetMapping("api/cinemas")
    ResponseEntity<CinemasReadDTO> getCinemas()
    {
        List<Cinema> cinemas = this.cinemaService.findAll(); //utilize services
        CinemasReadDTO cinemasReadDTO = this.cinemasToCinemasReadDTO.apply(cinemas); // translate between business entities and DTO objects.
        HttpHeaders headers = new HttpHeaders(); // headers for debugging purposes
        headers.add("Responded", "CinemaController");
        return ResponseEntity.accepted().headers(headers).body(cinemasReadDTO);
    }

    @GetMapping("api/cinemas/{uuid}")
    ResponseEntity<CinemaReadDTO> getCinema(@PathVariable UUID uuid)
    {
        try
        {
            Cinema cinema = this.cinemaService.findById(uuid);
            CinemaReadDTO cinemaReadDTO = cinemaToCinemaReadDTO.apply(cinema);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "CinemaController");
            return ResponseEntity.status(HttpStatus.OK).headers(headers).body(cinemaReadDTO);
        }
        catch (EntityNotFoundException e) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "CinemaController");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).build();
        }

    }

    @PutMapping("api/cinemas/{uuid}")
    ResponseEntity<String> putCinema(@PathVariable UUID uuid, @RequestBody CinemaCreateDTO cinemaCreateDTO)
    {
        try
        {
            Cinema cinema = this.cinemaService.findById(uuid);
            this.cinemaService.create(this.cinemaCreateDTOToCinema.apply(uuid, cinemaCreateDTO));
            String body = "Successfully updated.";
            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "CinemaController");
            return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(body);
        }
        catch (EntityNotFoundException e) {
            Cinema cinema = this.cinemaCreateDTOToCinema.apply(uuid, cinemaCreateDTO);
            this.cinemaService.create(cinema);
            String body = "Successfully created.";
            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "CinemaController");
            return ResponseEntity.status(HttpStatus.OK).headers(headers).body(body);
        }
    }

    @DeleteMapping("api/cinemas/{uuid}")
    ResponseEntity<String> deleteCinema(@PathVariable UUID uuid)
    {
        try
        {
            Cinema cinema = this.cinemaService.findById(uuid);
            this.cinemaService.deleteById(uuid);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "CinemaController");
            return ResponseEntity.status(HttpStatus.OK).headers(headers).body("Succesfully deleted "+ uuid.toString());
        }
        catch (EntityNotFoundException e)
        {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Not Found", "CinemaController");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).build();
        }


    }

}
