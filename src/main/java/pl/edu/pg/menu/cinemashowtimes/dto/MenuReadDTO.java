package pl.edu.pg.menu.cinemashowtimes.dto;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class MenuReadDTO {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
}
