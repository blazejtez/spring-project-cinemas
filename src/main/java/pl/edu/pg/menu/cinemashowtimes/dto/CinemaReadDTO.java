package pl.edu.pg.menu.cinemashowtimes.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;
import pl.edu.pg.menu.cinemashowtimes.entity.Showtime;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class CinemaReadDTO {
    private String name;
    private String street;
    private String city;
    private String zipCode;
    private int employeesNumber;
    private String phoneNumber;
    private String description;
    private Date openingDate;
}
