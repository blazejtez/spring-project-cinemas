package pl.edu.pg.Cinemas.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.Cinemas.entity.Cinema;
import pl.edu.pg.Cinemas.event.repository.EventRepository;
import pl.edu.pg.Cinemas.repository.CinemaRepository;

import java.util.*;

@Service
public class CinemaService {
    private final CinemaRepository cinemaRepository;
    private final EventRepository eventRepository;

    @Autowired
    public CinemaService(CinemaRepository cinemaRepository, EventRepository eventRepository) {
        this.cinemaRepository = cinemaRepository;
        this.eventRepository = eventRepository;
    }

    public void create(Cinema cinema) {
        cinemaRepository.save(cinema);
        eventRepository.create(cinema.getId());
    }

    public List<Cinema> findAll() {
        return cinemaRepository.findAll();
    }

    public Cinema findById(UUID uuid) {
        return this.cinemaRepository
                .findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Cinema with id: " + uuid + "not found"));
    }

    @Transactional
    public void deleteById(UUID uuid) {
        eventRepository.delete(uuid);
        this.cinemaRepository.deleteById(uuid);
    }

}
