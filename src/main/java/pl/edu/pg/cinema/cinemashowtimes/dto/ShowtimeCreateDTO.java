package pl.edu.pg.cinema.cinemashowtimes.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class ShowtimeCreateDTO {
    private String movieTitle;
    private String showRoomName;
    private BigDecimal ticketPrice;
    private int numberOfTickets;
    private LocalDateTime screeningTime;
    //private UUID cinema; pobierane z URL
}