package pl.edu.pg.Showtimes.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.Showtimes.entity.Cinema;
import pl.edu.pg.Showtimes.repository.CinemaRepository;

import java.util.*;

@Service
public class CinemaService {
    private final CinemaRepository cinemaRepository;

    @Autowired
    public CinemaService(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    public void create(Cinema cinema) {
        cinemaRepository.save(cinema);
    }

    public List<Cinema> findAll() {
        return cinemaRepository.findAll();
    }

    public Cinema findById(UUID uuid) {
        return this.cinemaRepository
                .findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Cinema with id: " + uuid + "not found"));
    }

    public void deleteById(UUID uuid) {
        this.cinemaRepository.deleteById(uuid);
    }

}
