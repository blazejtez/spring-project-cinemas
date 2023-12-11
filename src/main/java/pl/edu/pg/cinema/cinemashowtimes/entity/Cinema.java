package pl.edu.pg.cinema.cinemashowtimes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "cinemas")
public class Cinema implements Comparable<Cinema>, Serializable {

    @Id
    private UUID id;

    private String name;
    private String street;
    private String city;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "employees_number")
    private int employeesNumber;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String description;
    @Column(name = "opening_date")
    private Date openingDate;
        @Singular
    @OneToMany(mappedBy = "cinema", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private List<Showtime> showtimes;

    @Override
    public String toString() {
        return name + street + city + zipCode;
    }

    @Override
    public int compareTo(Cinema o) {
        {
            return this.openingDate.compareTo(o.getOpeningDate());
        }
    }
}
