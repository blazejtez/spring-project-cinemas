package pl.edu.pg.menu.cinemashowtimes.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pg.menu.cinemashowtimes.entity.Cinema;
import pl.edu.pg.menu.cinemashowtimes.entity.Showtime;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, UUID> {
    Optional<List<Showtime>> findByCinema(Cinema cinema);
}
