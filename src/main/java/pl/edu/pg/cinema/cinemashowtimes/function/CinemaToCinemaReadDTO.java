package pl.edu.pg.cinema.cinemashowtimes.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.cinema.cinemashowtimes.dto.CinemaReadDTO;
import pl.edu.pg.cinema.cinemashowtimes.entity.Cinema;

import java.util.function.Function;
@Component
public class CinemaToCinemaReadDTO implements Function<Cinema, CinemaReadDTO> {
    @Override
    public CinemaReadDTO apply(Cinema entity) {
        return CinemaReadDTO.builder()
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
