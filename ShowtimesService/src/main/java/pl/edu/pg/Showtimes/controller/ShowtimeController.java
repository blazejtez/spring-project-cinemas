package pl.edu.pg.Showtimes.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pg.Showtimes.dto.ShowtimeReadDTO;
import pl.edu.pg.Showtimes.dto.ShowtimesReadDTO;
import pl.edu.pg.Showtimes.entity.Showtime;
import pl.edu.pg.Showtimes.function.ShowtimeCreateDTOToShowtime;
import pl.edu.pg.Showtimes.function.ShowtimeToShowtimeReadDTO;
import pl.edu.pg.Showtimes.function.ShowtimesToShowtimesReadDTO;
import pl.edu.pg.Showtimes.service.ShowtimeService;

import java.util.List;
import java.util.UUID;
@RestController
public class ShowtimeController {
    private final ShowtimeService showtimeService;
    private final ShowtimesToShowtimesReadDTO showtimesToShowtimesReadDTO;
    private final ShowtimeToShowtimeReadDTO showtimeToShowtimeReadDTO;

    @Autowired
    public ShowtimeController(ShowtimeService showtimeService,
                              ShowtimesToShowtimesReadDTO showtimesToShowtimesReadDTO,
                              ShowtimeToShowtimeReadDTO showtimeToShowtimeReadDTO) {
        this.showtimeService = showtimeService;
        this.showtimesToShowtimesReadDTO = showtimesToShowtimesReadDTO;
        this.showtimeToShowtimeReadDTO = showtimeToShowtimeReadDTO;
    }
    @GetMapping("api/showtimes")
    ResponseEntity<ShowtimesReadDTO> getShowtimes()
    {
        List<Showtime> showtimes = this.showtimeService.findAll();
        ShowtimesReadDTO showtimesReadDTO = this.showtimesToShowtimesReadDTO.apply(showtimes);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "ShowtimeController");
        return ResponseEntity.accepted().headers(headers).body(showtimesReadDTO);
    }
    @GetMapping("api/showtimes/{uuid}")
    ResponseEntity<ShowtimeReadDTO> getShowtime(@PathVariable UUID uuid)
    {
        try
        {
            Showtime showtime = this.showtimeService.findById(uuid);
            ShowtimeReadDTO showtimeReadDTO = showtimeToShowtimeReadDTO.apply(showtime);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "ShowtimeController");
            return ResponseEntity.accepted().headers(headers).body(showtimeReadDTO);
        }
        catch (EntityNotFoundException e) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "ShowtimeController");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).build();
        }
    }
    @DeleteMapping("api/showtimes/{uuid}")
    ResponseEntity<String> deleteShowtime(@PathVariable UUID uuid)
    {
        try
        {
            Showtime showtime = this.showtimeService.findById(uuid);
            this.showtimeService.deleteById(uuid);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "ShowtimeController");
            return ResponseEntity.status(HttpStatus.OK).headers(headers).body("Succesfully deleted "+ uuid.toString());
        }
        catch (EntityNotFoundException e)
        {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Responded", "ShowtimeController");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).body("No showtime with id:  "+ uuid.toString());
        }
    }

}
