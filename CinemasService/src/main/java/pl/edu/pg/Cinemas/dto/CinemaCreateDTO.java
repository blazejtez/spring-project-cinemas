package pl.edu.pg.Cinemas.dto;

import lombok.*;

import java.util.Date;

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
    private Date openingDate;
}
