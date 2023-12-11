package pl.edu.pg.menu.cinemashowtimes.dto;

import lombok.*;

import java.math.BigDecimal;
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
    private UUID cinema;
}