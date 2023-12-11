package pl.edu.pg.menu.cinemashowtimes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

//kina:
// int employeeCount
// string zip code
// string street
// string city
// string phoneNumber
// string description


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "cinemas")
public class Cinema implements Comparable<Cinema>, Serializable {

    @Id
    private UUID id;

    private String name;
    private String address;
    @Column(name = "employees_number")
    private int employeesNumber;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;

//    @Singular
    @OneToMany(mappedBy = "cinema", cascade = CascadeType.REMOVE, fetch=FetchType.LAZY)
//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    @JsonIgnore
    private List<Showtime> showtimes;
//    @Override
//    public String toString() {
//        return "Menu [id=" + id + ", name=" + name + ", start date=" + startDate + ", end date=" + endDate + "]";
//    }
    @Override
    public int compareTo(Cinema o) {
        {
            return this.startDate.compareTo(o.getStartDate());
        }
    }
}
