//package pl.edu.pg.cinema.cinemashowtimes.controller;
//
//import jakarta.persistence.EntityNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import pl.edu.pg.cinema.cinemashowtimes.entity.Showtime;
//import pl.edu.pg.cinema.cinemashowtimes.service.ShowtimeService;
//import pl.edu.pg.cinema.cinemashowtimes.function.ShowtimesToShowtimesReadDTO;
//import pl.edu.pg.cinema.cinemashowtimes.function.ShowtimeToShowtimeReadDTO;
//import pl.edu.pg.cinema.cinemashowtimes.function.ShowtimeToShowtimeCreateDTO;
//import pl.edu.pg.cinema.cinemashowtimes.dto.ShowtimesReadDTO;
//import pl.edu.pg.cinema.cinemashowtimes.dto.ShowtimeReadDTO;
//import pl.edu.pg.cinema.cinemashowtimes.dto.ShowtimeCreateDTO;
//
//import java.util.List;
//import java.util.UUID;
//@RestController
//public class ShowtimeController {
//    private final ShowtimeService showtimeService;
//    private final ShowtimesToShowtimesReadDTO showtimesToShowtimesReadDTO;
//    private final ShowtimeToShowtimeReadDTO showtimeToShowtimeReadDTO;
//    private final ShowtimeToShowtimeCreateDTO showtimeToShowtimeCreateDTO;
//
//    @Autowired
//    public ShowtimeController(ShowtimeService showtimeService,
//                            ShowtimesToShowtimesReadDTO showtimesToShowtimesReadDTO,
//                            ShowtimeToShowtimeReadDTO showtimeToShowtimeReadDTO,
//                            ShowtimeToShowtimeCreateDTO showtimeToShowtimeCreateDTO) {
//        this.showtimeService = showtimeService;
//        this.showtimesToShowtimesReadDTO = showtimesToShowtimesReadDTO;
//        this.showtimeToShowtimeReadDTO = showtimeToShowtimeReadDTO;
//        this.showtimeToShowtimeCreateDTO = showtimeToShowtimeCreateDTO;
//    }
//
//
//    @GetMapping("api/showtimes")
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    ResponseEntity<ShowtimesReadDTO> getShowtimes()
//    {
//        List<Showtime> showtimes = this.showtimeService.findAll();
//        ShowtimesReadDTO showtimesReadDTO = this.showtimesToShowtimesReadDTO.apply(showtimes);
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Responded", "ShowtimeController");
//        return ResponseEntity.accepted().headers(headers).body(showtimesReadDTO);
//    }
//
//    @GetMapping("api/cinemas/{cinemaUuid}/showtimes/")
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    ResponseEntity<ShowtimesReadDTO> getCinemaShowtimes(@PathVariable UUID cinemaUuid)
//    {
//        List<Showtime> showtimes = this.showtimeService.findFromCinema(cinemaUuid);
//        ShowtimesReadDTO showtimesReadDTO = this.showtimesToShowtimesReadDTO.apply(showtimes);
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Responded", "ShowtimeController");
//        return ResponseEntity.accepted().headers(headers).body(showtimesReadDTO);
//    }
//
//    @PostMapping("api/cinemas/{cinemaUuid}/showtimes/")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    @ResponseBody
//    ResponseEntity<String> postShowtime(@RequestBody ShowtimeCreateDTO showtimeCreateDTO, @RequestParam UUID cinemaUuid)
//    {
//        this.showtimeService.create(showtimeCreateDTO, cinemaUuid);
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Responded", "ShowtimesController");
//        return ResponseEntity.accepted().headers(headers).body("Successfully created");
//    }
//
//    @DeleteMapping("api/showtimes/{uuid}")
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    ResponseEntity<String> deleteShowtime(@PathVariable UUID uuid)
//    {
//        try
//        {
//            Showtime showtime = this.showtimeService.findById(uuid);
//            this.showtimeService.deleteById(uuid);
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("Responded", "ShowtimeController");
//            return ResponseEntity.accepted().headers(headers).body("Succesfully deleted "+ uuid.toString());
//        }
//        catch (EntityNotFoundException e)
//        {
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("Not Found", "ShowtimeController");
//            return ResponseEntity.notFound().headers(headers).build();
//        }
//    }
//    @GetMapping("api/showtimes/{uuid}")
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ResponseBody
//    ResponseEntity<ShowtimeReadDTO> getShowtime(@PathVariable UUID uuid)
//    {
//        try
//        {
//            Showtime showtime = this.showtimeService.findById(uuid);
//            ShowtimeReadDTO showtimeReadDTO = showtimeToShowtimeReadDTO.apply(showtime);
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("Responded", "ShowtimeController");
//            return ResponseEntity.accepted().headers(headers).body(showtimeReadDTO);
//        }
//        catch (EntityNotFoundException e) {
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("Responded", "ShowtimeController");
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).build();
//        }
//    }
//}
