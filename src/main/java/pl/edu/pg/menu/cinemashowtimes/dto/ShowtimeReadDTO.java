package pl.edu.pg.menu.cinemashowtimes.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class ShowtimeReadDTO {
    private String title;
    private BigDecimal ticketPrice;
}
