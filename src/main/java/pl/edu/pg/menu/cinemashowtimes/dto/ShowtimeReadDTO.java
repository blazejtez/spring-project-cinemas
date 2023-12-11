package pl.edu.pg.menu.cinemashowtimes.dto;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import pl.edu.pg.menu.cinemashowtimes.entity.Cinema;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

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
    private int numberOfTickets;
    private LocalDateTime screeningTime;
    private UUID cinema;
}
