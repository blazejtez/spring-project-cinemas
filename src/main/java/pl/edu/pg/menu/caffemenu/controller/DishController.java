package pl.edu.pg.menu.caffemenu.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.edu.pg.menu.caffemenu.dto.DishReadDTO;
import pl.edu.pg.menu.caffemenu.dto.DishesReadDTO;
import pl.edu.pg.menu.caffemenu.dto.MenusReadDTO;
import pl.edu.pg.menu.caffemenu.entity.Dish;
import pl.edu.pg.menu.caffemenu.function.DishToDeleteDishDTO;
import pl.edu.pg.menu.caffemenu.function.DishToDishReadDTO;
import pl.edu.pg.menu.caffemenu.function.DishToDishUpdateDTO;
import pl.edu.pg.menu.caffemenu.function.DishesToDishesReadDTO;
import pl.edu.pg.menu.caffemenu.service.DishService;

import java.util.List;
import java.util.Optional;
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
        List<Dish> dishes;
        dishes = this.dishService.findAll();
        return dishesToDishesReadDTO.apply(dishes);
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
    public ResponseEntity<Dish> getDish(@PathVariable UUID id)
    {
        List<Dish> dishes;
        dishes = this.dishService.findById();
        return dishes;
    }
}
