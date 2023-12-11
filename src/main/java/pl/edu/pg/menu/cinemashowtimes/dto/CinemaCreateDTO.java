package pl.edu.pg.menu.cinemashowtimes.dto;

import lombok.*;
import pl.edu.pg.menu.cinemashowtimes.entity.Showtime;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class CinemaCreateDTO {
    private String name;
    private String street;
    private String city;
    private String zipCode;
    private int employeesNumber;
    private String phoneNumber;
    private String description;
    private Date openingDate;
}
