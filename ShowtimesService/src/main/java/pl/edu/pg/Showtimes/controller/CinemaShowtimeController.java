package pl.edu.pg.Showtimes.controller;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pg.Showtimes.dto.ShowtimeCreateDTO;
import pl.edu.pg.Showtimes.dto.ShowtimeReadDTO;
import pl.edu.pg.Showtimes.dto.ShowtimesReadDTO;
import pl.edu.pg.Showtimes.entity.Showtime;
import pl.edu.pg.Showtimes.function.ShowtimeCreateDTOToShowtime;
import pl.edu.pg.Showtimes.function.ShowtimeToShowtimeReadDTO;
import pl.edu.pg.Showtimes.function.ShowtimesToShowtimesReadDTO;
import pl.edu.pg.Showtimes.service.CinemaService;
import pl.edu.pg.Showtimes.service.ShowtimeService;

import java.util.List;
import java.util.UUID;
@Slf4j
@RestController
@RequestMapping("api/cinemas/{cinemaUuid}/showtimes")
public class CinemaShowtimeController {
    private final ShowtimeService showtimeService;
    private final ShowtimesToShowtimesReadDTO showtimesToShowtimesReadDTO;
    private final ShowtimeToShowtimeReadDTO showtimeToShowtimeReadDTO;
    private final ShowtimeCreateDTOToShowtime showtimeCreateDTOToShowtime;
    private final CinemaService cinemaService;

    public CinemaShowtimeController(ShowtimeService showtimeService,
                                    ShowtimesToShowtimesReadDTO showtimesToShowtimesReadDTO,
                                    ShowtimeToShowtimeReadDTO showtimeToShowtimeReadDTO,
                                    ShowtimeCreateDTOToShowtime showtimeCreateDTOToShowtime,
                                    CinemaService cinemaService) {
        this.showtimeService = showtimeService;
        this.showtimesToShowtimesReadDTO = showtimesToShowtimesReadDTO;
        this.showtimeToShowtimeReadDTO = showtimeToShowtimeReadDTO;
        this.showtimeCreateDTOToShowtime = showtimeCreateDTOToShowtime;
        this.cinemaService = cinemaService;
    }

    @GetMapping
    ResponseEntity<ShowtimesReadDTO> getCinemaShowtimes(@PathVariable UUID cinemaUuid)
    {
        log.error("GETTING SHOWTIMES");
        try {
            this.cinemaService.findById(cinemaUuid);
        }
        catch (EntityNotFoundException e)
        {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "CinemaShowtimeController");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).build();
        }
        List<Showtime> showtimes = this.showtimeService.findFromCinema(cinemaUuid);
        ShowtimesReadDTO showtimesReadDTO = this.showtimesToShowtimesReadDTO.apply(showtimes);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "CinemaShowtimeController");
        return ResponseEntity.accepted().headers(headers).body(showtimesReadDTO);
    }

    @GetMapping("{showtimeUuid}")
    ResponseEntity<ShowtimeReadDTO> getShowtime(@PathVariable UUID cinemaUuid, @PathVariable UUID showtimeUuid)
    {
        log.error("GETTING SHOWTIME");
        try {
            this.cinemaService.findById(cinemaUuid);
        }
        catch (EntityNotFoundException e)
        {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "CinemaShowtimeController");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).build();
        }
        try
        {
            Showtime showtime = this.showtimeService.findById(showtimeUuid);
            ShowtimeReadDTO showtimeReadDTO = this.showtimeToShowtimeReadDTO.apply(showtime);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "CinemaShowtimeController");
            return ResponseEntity.status(HttpStatus.OK).headers(headers).body(showtimeReadDTO);
        }
        catch (EntityNotFoundException e)
        {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "CinemaShowtimeController");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).build();
        }

    }

    @PutMapping("{showtimeUuid}")
    ResponseEntity<String> postShowtime(@RequestBody ShowtimeCreateDTO showtimeCreateDTO, @PathVariable UUID cinemaUuid,
                                        @PathVariable UUID showtimeUuid)
    {
        log.error("PUTTING SHOWTIME");
        try
        {
            Showtime showtime = showtimeCreateDTOToShowtime.apply(cinemaUuid, showtimeUuid, showtimeCreateDTO);
            this.showtimeService.create(showtime);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "CinemaShowtimeController");
            return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();
        }
        catch (EntityNotFoundException e)
        {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "CinemaShowtimeController");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).build();
        }

    }
    @DeleteMapping("{showtimeUuid}")
    ResponseEntity<String> deleteShowtime(@PathVariable UUID showtimeUuid, @PathVariable UUID cinemaUuid)
    {
        log.error("DELETING SHOWTIME");
        try {
            this.cinemaService.findById(cinemaUuid);
        }
        catch (EntityNotFoundException e)
        {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "CinemaShowtimeController");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).build();
        }
        try
        {
            Showtime showtime = this.showtimeService.findById(showtimeUuid);
            this.showtimeService.deleteById(showtimeUuid);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "CinemaShowtimeController");
            return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
        }
        catch (EntityNotFoundException e)
        {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "CinemaShowtimeController");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).build();
        }
    }
    @PostMapping
    ResponseEntity<String> postShowtime(@RequestBody ShowtimeCreateDTO showtimeCreateDTO, @PathVariable UUID cinemaUuid)
    {
        log.error("CREATING SHOWTIME");
        UUID showtimeUuid = UUID.randomUUID();
        Showtime showtime = showtimeCreateDTOToShowtime.apply(cinemaUuid, showtimeUuid, showtimeCreateDTO);
        this.showtimeService.create(showtime);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "CinemaShowtimeController");
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();

    }


}
