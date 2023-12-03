package pl.edu.pg.menu.caffemenu.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;
import pl.edu.pg.menu.caffemenu.entity.Dish;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class MenuUpdateDTO {
    @Id
    private UUID id;

    private String name;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    private List<Dish> dishes;
}
