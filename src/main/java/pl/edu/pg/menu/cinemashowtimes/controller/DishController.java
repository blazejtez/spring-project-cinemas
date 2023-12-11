package pl.edu.pg.menu.cinemashowtimes.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.edu.pg.menu.cinemashowtimes.dto.DishesReadDTO;
import pl.edu.pg.menu.cinemashowtimes.entity.Showtime;
import pl.edu.pg.menu.cinemashowtimes.function.DishToDeleteDishDTO;
import pl.edu.pg.menu.cinemashowtimes.function.DishToDishReadDTO;
import pl.edu.pg.menu.cinemashowtimes.function.DishToDishUpdateDTO;
import pl.edu.pg.menu.cinemashowtimes.function.DishesToDishesReadDTO;
import pl.edu.pg.menu.cinemashowtimes.service.DishService;

import java.util.List;
import java.util.UUID;

public class DishController {
    public DishController(DishService dishService,
                          DishesToDishesReadDTO dishesToDishesReadDTO,
                          DishToDeleteDishDTO dishToDeleteDishDTO,
                          DishToDishReadDTO dishToDishReadDTO,
                          DishToDishUpdateDTO dishToDishUpdateDTO) {
        this.dishService = dishService;
        this.dishesToDishesReadDTO = dishesToDishesReadDTO;
        this.dishToDeleteDishDTO = dishToDeleteDishDTO;
        this.dishToDishReadDTO = dishToDishReadDTO;
        this.dishToDishUpdateDTO = dishToDishUpdateDTO;
    }

    private final DishService dishService;
    private final DishesToDishesReadDTO dishesToDishesReadDTO;
    private final DishToDeleteDishDTO dishToDeleteDishDTO;
    private final DishToDishReadDTO dishToDishReadDTO;
    private final DishToDishUpdateDTO dishToDishUpdateDTO;



    //get dishes
    @GetMapping("api/dishes")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public DishesReadDTO getDishes()
    {
        List<Showtime> showtimes;
        showtimes = this.dishService.findAll();
        return dishesToDishesReadDTO.apply(showtimes);
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
        Showtime showtime = this.dishService.findById(uuid);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "DishController");
        return ResponseEntity.accepted().headers(headers).body(showtime);
    }
}
