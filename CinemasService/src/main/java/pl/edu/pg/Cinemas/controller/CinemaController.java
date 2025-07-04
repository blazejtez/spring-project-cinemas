package pl.edu.pg.Cinemas.controller;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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

@Slf4j
@RestController
@RequestMapping("api/cinemas")
public class CinemaController {
    private final CinemaService cinemaService;
    private final CinemasToCinemasReadDTO cinemasToCinemasReadDTO;
    private final CinemaToCinemaReadDTO cinemaToCinemaReadDTO;
    private final CinemaCreateDTOToCinema cinemaCreateDTOToCinema;

    private final LoadBalancerClient loadBalancerClient;

    @Autowired
    public CinemaController(CinemaService cinemaService, CinemasToCinemasReadDTO cinemasToCinemasReadDTO, CinemaToCinemaReadDTO cinemaToCinemaReadDTO, CinemaCreateDTOToCinema cinemaCreateDTOToCinema, LoadBalancerClient loadBalancerClient) {
        this.cinemaService = cinemaService;
        this.cinemasToCinemasReadDTO = cinemasToCinemasReadDTO;
        this.cinemaToCinemaReadDTO = cinemaToCinemaReadDTO;
        this.cinemaCreateDTOToCinema = cinemaCreateDTOToCinema;
        this.loadBalancerClient = loadBalancerClient;
    }

    // logic: the requests is always correct, no reason to throw Exceptions.
    @GetMapping
    ResponseEntity<CinemasReadDTO> getCinemas() {
        log.info("Get all cinemas");
        List<Cinema> cinemas = this.cinemaService.findAll(); //utilize services
        CinemasReadDTO cinemasReadDTO = this.cinemasToCinemasReadDTO.apply(cinemas); // translate between business entities and DTO objects.
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(cinemasReadDTO);
    }

    @GetMapping("/ups")
    String printAll() {
        String answers = new String();
        try
        {
            for(int i=0; i<10; i++)
            {
                log.error(loadBalancerClient.choose("showtimes-service").getUri().toString());
                answers = answers + " " + loadBalancerClient.choose("showtimes-service").toString();
            }

            return answers;
        }
        catch (Exception e)
        {
            log.error("EUREKA CONTROLLER TRY FAILED");
            answers = answers + e.getMessage();
            return answers;
        }
    }

    @GetMapping("{uuid}")
    ResponseEntity<CinemaReadDTO> getCinema(@PathVariable UUID uuid) {
        try {
            Cinema cinema = this.cinemaService.findById(uuid);
            CinemaReadDTO cinemaReadDTO = cinemaToCinemaReadDTO.apply(cinema);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "CinemaController");
            return ResponseEntity.status(HttpStatus.OK).headers(headers).body(cinemaReadDTO);
        } catch (EntityNotFoundException e) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "CinemaController");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).build();
        }

    }

    @PutMapping("{uuid}")
    ResponseEntity<String> putCinema(@PathVariable UUID uuid, @RequestBody CinemaCreateDTO cinemaCreateDTO) {
        try {
            Cinema cinema = this.cinemaService.findById(uuid);
            this.cinemaService.create(this.cinemaCreateDTOToCinema.apply(uuid, cinemaCreateDTO));
            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "CinemaController");
            return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();
        } catch (EntityNotFoundException e) {
            Cinema cinema = this.cinemaCreateDTOToCinema.apply(uuid, cinemaCreateDTO);
            this.cinemaService.create(cinema);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "CinemaController");
            return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
        }
    }

    @DeleteMapping("{uuid}")
    ResponseEntity<String> deleteCinema(@PathVariable UUID uuid)
    {
        try
        {
            Cinema cinema = this.cinemaService.findById(uuid);
            this.cinemaService.deleteById(uuid);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        catch (EntityNotFoundException e)
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
    @PostMapping
    ResponseEntity<String> postCinema(@RequestBody CinemaCreateDTO cinemaCreateDTO) {
        UUID uuid = UUID.randomUUID();
        this.cinemaService.create(this.cinemaCreateDTOToCinema.apply(uuid, cinemaCreateDTO));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "CinemaController");
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();
    }

}
