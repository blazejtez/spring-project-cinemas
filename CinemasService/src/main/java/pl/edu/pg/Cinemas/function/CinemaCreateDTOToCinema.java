package pl.edu.pg.Cinemas.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.Cinemas.dto.CinemaCreateDTO;
import pl.edu.pg.Cinemas.entity.Cinema;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class CinemaCreateDTOToCinema implements BiFunction<UUID, CinemaCreateDTO, Cinema> {
    @Override
    public Cinema apply(UUID uuid, CinemaCreateDTO dto) {
        return Cinema.builder()
                .id(uuid)
                .name(dto.getName())
                .street(dto.getStreet())
                .city(dto.getCity())
                .zipCode(dto.getZipCode())
                .employeesNumber(dto.getEmployeesNumber())
                .phoneNumber(dto.getPhoneNumber())
                .openingDate(dto.getOpeningDate())
                .build();
    }
}
