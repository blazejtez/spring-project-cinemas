package pl.edu.pg.cinema.cinemashowtimes.dto;


import lombok.*;

import java.util.Date;

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
