package pl.edu.pg.Showtimes.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class ShowtimeReadDTO {
    private String movieTitle;
    private String showRoomName;
    private BigDecimal ticketPrice;
    private LocalDateTime screeningTime;
}
