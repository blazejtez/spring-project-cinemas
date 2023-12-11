package pl.edu.pg.cinema.cinemashowtimes.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.edu.pg.cinema.cinemashowtimes.dto.ShowtimesReadDTO;
import pl.edu.pg.cinema.cinemashowtimes.entity.Showtime;
import pl.edu.pg.cinema.cinemashowtimes.function.ShowtimeToShowtimeReadDTO;
import pl.edu.pg.cinema.cinemashowtimes.function.ShowtimeToShowtimeCreateDTO;
import pl.edu.pg.cinema.cinemashowtimes.function.ShowtimesToShowtimesReadDTO;
import pl.edu.pg.cinema.cinemashowtimes.service.ShowtimeService;

import java.util.List;
import java.util.UUID;

public class ShowtimeController {
    public ShowtimeController(ShowtimeService showtimeService,
                              ShowtimesToShowtimesReadDTO showtimesToShowtimesReadDTO,
                              ShowtimeToShowtimeReadDTO showtimeToShowtimeReadDTO,
                              ShowtimeToShowtimeCreateDTO showtimeToShowtimeCreateDTO) {
        this.showtimeService = showtimeService;
        this.showtimesToShowtimesReadDTO = showtimesToShowtimesReadDTO;
        this.showtimeToShowtimeReadDTO = showtimeToShowtimeReadDTO;
        this.showtimeToShowtimeCreateDTO = showtimeToShowtimeCreateDTO;
    }

    private final ShowtimeService showtimeService;
    private final ShowtimesToShowtimesReadDTO showtimesToShowtimesReadDTO;
    private final ShowtimeToShowtimeReadDTO showtimeToShowtimeReadDTO;
    private final ShowtimeToShowtimeCreateDTO showtimeToShowtimeCreateDTO;



    //get dishes
    @GetMapping("api/dishes")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ShowtimesReadDTO getDishes()
    {
        List<Showtime> showtimes;
        showtimes = this.showtimeService.findAll();
        return showtimesToShowtimesReadDTO.apply(showtimes);
    }

//    @GetMapping("api/{category}/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    public DishReadDTO getDish()
//    {
//        dish = this.dishService.();
//        return dishesToDishesReadDTO.apply(dish);
//    }

    @GetMapping("api/dishes/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<Showtime> getDish(@PathVariable UUID uuid)
    {
        Showtime showtime = this.showtimeService.findById(uuid);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "DishController");
        return ResponseEntity.accepted().headers(headers).body(showtime);
    }
}
