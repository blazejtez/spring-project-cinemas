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



    public void create(CinemaCreateDTO cinema) {
        Cinema entity = Cinema.builder()
                .id(UUID.randomUUID())
                .name(cinema.getName())
                .city(cinema.getCity())
                .street(cinema.getStreet())
                .zipCode(cinema.getZipCode())
                .openingDate(cinema.getOpeningDate())
                .employeesNumber(cinema.getEmployeesNumber())
                .phoneNumber(cinema.getPhoneNumber())
                .description(cinema.getName()
                        + " in "
                        + cinema.getCity()
                        + ", showing best movies since "
                        + cinema.getOpeningDate())
                .build();
        cinemaRepository.save(entity);

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
