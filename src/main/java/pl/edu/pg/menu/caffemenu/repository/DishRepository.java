package pl.edu.pg.menu.caffemenu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pg.menu.caffemenu.entity.Dish;
import pl.edu.pg.menu.caffemenu.entity.Menu;

import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.UUID;
import java.util.function.Function;

@Repository
public interface DishRepository extends JpaRepository<Dish, UUID> {
    Optional<List<Dish>> findByMenu(Menu menu);
}
