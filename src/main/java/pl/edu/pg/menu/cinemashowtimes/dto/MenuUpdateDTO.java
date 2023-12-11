package pl.edu.pg.menu.cinemashowtimes.dto;

import lombok.*;
import pl.edu.pg.menu.cinemashowtimes.entity.Showtime;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class MenuUpdateDTO {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Showtime> showtimes;
}
