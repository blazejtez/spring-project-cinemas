package pl.edu.pg.menu.cinemashowtimes.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pg.menu.cinemashowtimes.entity.Cinema;
import pl.edu.pg.menu.cinemashowtimes.entity.Showtime;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DishRepository extends JpaRepository<Showtime, UUID> {
    Optional<List<Showtime>> findByMenu(Cinema cinema);
}
