package pl.edu.pg.cinema.cinemashowtimes.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.cinema.cinemashowtimes.dto.CinemaCreateDTO;
import pl.edu.pg.cinema.cinemashowtimes.entity.Cinema;

import java.util.function.Function;

@Component

public class CinemaToCinemaCreateDTO implements Function<Cinema, CinemaCreateDTO> {
    @Override
    public CinemaCreateDTO apply(Cinema entity) {
        return CinemaCreateDTO.builder()
                .name(entity.getName())
                .street(entity.getStreet())
                .city(entity.getCity())
                .zipCode(entity.getZipCode())
                .employeesNumber(entity.getEmployeesNumber())
                .phoneNumber(entity.getPhoneNumber())
                .openingDate(entity.getOpeningDate())
                .build();
    }

}
