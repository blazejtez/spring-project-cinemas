package pl.edu.pg.menu.caffemenu.dto;


import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

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
