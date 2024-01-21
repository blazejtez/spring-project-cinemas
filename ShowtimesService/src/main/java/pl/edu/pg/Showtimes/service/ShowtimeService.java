package pl.edu.pg.Showtimes.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import pl.edu.pg.Showtimes.entity.Showtime;
import pl.edu.pg.Showtimes.repository.ShowtimeRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ShowtimeService {
    private ShowtimeRepository showtimeRepository;
    public ShowtimeService(ShowtimeRepository showtimeRepository) {
        this.showtimeRepository = showtimeRepository;
    }


    public void create(Showtime showtime) {
        showtimeRepository.save(showtime);
    }

    public List<Showtime> findAll() {
        return this.showtimeRepository.findAll();
    }
    public void delete(UUID uuid) {
        Optional<Showtime> optionalShowtime = this.showtimeRepository.findById(uuid);
        optionalShowtime.ifPresent(showtime -> this.showtimeRepository.delete(showtime));
    }

    public Showtime findById(UUID uuid) {
        Showtime showtime = this.showtimeRepository
                .findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Showtime not found with id: " + uuid));
        return showtime;
    }

    public void deleteById(UUID uuid) {
        Showtime showtime = this.showtimeRepository
                .findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Showtime not found with id: " + uuid));
        this.showtimeRepository.deleteById(uuid);
    }

    public List<Showtime> findFromCinema(UUID cinemaUuid) {
        return findAll().stream()
                .filter(item -> item.getCinema().getId().equals(cinemaUuid))
                .toList();
    }
}
