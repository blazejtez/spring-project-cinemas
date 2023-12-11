package pl.edu.pg.menu.cinemashowtimes.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class ShowtimesReadDTO {
    @Getter
    @Setter
    @Builder(access = AccessLevel.PUBLIC)
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Showtime {
        private UUID id;
        private String description;

    }
    @Singular("dish")
    private List<Showtime> showtimes;
}
