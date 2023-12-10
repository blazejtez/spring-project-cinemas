package pl.edu.pg.menu.caffemenu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pg.menu.caffemenu.entity.Cinema;
import pl.edu.pg.menu.caffemenu.entity.Showtime;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DishRepository extends JpaRepository<Showtime, UUID> {
    Optional<List<Showtime>> findByMenu(Cinema cinema);
}
