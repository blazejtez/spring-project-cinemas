package pl.edu.pg.menu.caffemenu.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import pl.edu.pg.menu.caffemenu.entity.Showtime;
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



    public void create(Showtime showtime) {
        dishRepository.save(showtime);
    }

    public List<Showtime> findAll() {
        return this.dishRepository.findAll();
    }
    public void delete(UUID uuid) {
        Optional<Showtime> optionalDish = this.dishRepository.findById(uuid);
        optionalDish.ifPresent(dish -> this.dishRepository.delete(dish));
    }

    public Showtime findById(UUID uuid) {
        Showtime showtime = this.dishRepository
                .findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Dish not found with id: " + uuid));
        return showtime;
    }
}
