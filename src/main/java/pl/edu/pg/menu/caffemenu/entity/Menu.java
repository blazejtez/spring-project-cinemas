package pl.edu.pg.menu.caffemenu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "menus")
public class Menu implements Comparable<Menu>, Serializable {

    @Id
    private UUID id;

    private String name;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;

    @OneToMany(mappedBy = "menu", fetch=FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private List<Dish> dishes;
//    @Override
//    public String toString() {
//        return "Menu [id=" + id + ", name=" + name + ", start date=" + startDate + ", end date=" + endDate + "]";
//    }
    @Override
    public int compareTo(Menu o) {
        {
            return this.startDate.compareTo(o.getStartDate());
        }
    }
}
