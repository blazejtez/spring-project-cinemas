package pl.edu.pg.cinema.cinemashowtimes.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.cinema.cinemashowtimes.dto.CinemaCreateDTO;
import pl.edu.pg.cinema.cinemashowtimes.repository.CinemaRepository;
import pl.edu.pg.cinema.cinemashowtimes.entity.Cinema;

import java.util.*;

@Service
public class CinemaService {
    private final CinemaRepository cinemaRepository;

    @Autowired
    public CinemaService(CinemaRepository menuRepository) {
        this.cinemaRepository = menuRepository;
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
