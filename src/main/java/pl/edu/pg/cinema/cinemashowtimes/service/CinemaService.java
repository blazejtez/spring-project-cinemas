package pl.edu.pg.cinema.cinemashowtimes.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.cinema.cinemashowtimes.dto.CinemaCreateDTO;
import pl.edu.pg.cinema.cinemashowtimes.function.CinemaToCinemaCreateDTO;
import pl.edu.pg.cinema.cinemashowtimes.repository.CinemaRepository;
import pl.edu.pg.cinema.cinemashowtimes.entity.Cinema;

import java.util.*;

@Service
public class CinemaService {
    private final CinemaRepository cinemaRepository;
    private final CinemaToCinemaCreateDTO cinemaToCinemaCreateDTO;

    @Autowired
    public CinemaService(CinemaRepository menuRepository, CinemaToCinemaCreateDTO cinemaToCinemaCreateDTO) {
        this.cinemaRepository = menuRepository;
        this.cinemaToCinemaCreateDTO = cinemaToCinemaCreateDTO;
    }



    public void create(CinemaCreateDTO cinema) {
        //TODO
        //ITS BACKWARDS
        CinemaCreateDTO cinemadto = this.cinemaToCinemaCreateDTO.apply(cinema);
        cinemaRepository.save(cinemadto);

    }

    public List<Cinema> findAll() {
        return cinemaRepository.findAll();
    }

    public Cinema findById(UUID uuid) {
        return this.cinemaRepository
                .findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Cinema not found with id: " + uuid));
    }

    public void deleteById(UUID uuid) {
        this.cinemaRepository.deleteById(uuid);
    }
}
