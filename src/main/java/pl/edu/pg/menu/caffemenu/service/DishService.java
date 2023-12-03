package pl.edu.pg.menu.caffemenu.service;

import org.springframework.stereotype.Service;
import pl.edu.pg.menu.caffemenu.entity.Dish;
import pl.edu.pg.menu.caffemenu.repository.DishRepository;

@Service
public class DishService {
    private DishRepository dishRepository;
    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }



    public void create(Dish dish) {
        dishRepository.save(dish);
    }
}
