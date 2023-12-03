package pl.edu.pg.menu.caffemenu.service;

import org.springframework.stereotype.Service;
import pl.edu.pg.menu.caffemenu.entity.Dish;
import pl.edu.pg.menu.caffemenu.entity.Menu;
import pl.edu.pg.menu.caffemenu.repository.DishRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DishService {
    private DishRepository dishRepository;
    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }



    public void create(Dish dish) {
        dishRepository.save(dish);
    }

    public List<Dish> findAll() {
        return this.dishRepository.findAll();
    }
    public void delete(UUID uuid) {
        Optional<Dish> optionalDish = this.dishRepository.findById(uuid);
        optionalDish.ifPresent(dish -> this.dishRepository.delete(dish));
    }
}
