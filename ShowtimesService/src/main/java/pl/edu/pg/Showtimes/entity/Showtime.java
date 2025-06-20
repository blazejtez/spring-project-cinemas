package pl.edu.pg.Showtimes.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;




@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "showtimes")
@ToString
public class Showtime implements Comparable<Showtime>, Serializable {
    @Id
    private UUID id;
    private String movieTitle;
    private String showRoomName;
    private BigDecimal ticketPrice;
    private int numberOfTickets;
    private LocalDateTime screeningTime;
    @ManyToOne
    @JoinColumn(name = "cinema")
    private Cinema cinema;


    @Override
    public int compareTo(Showtime o) {
        return this.ticketPrice.compareTo(o.getTicketPrice());
    }


}
