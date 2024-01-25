package pl.edu.pg.Showtimes.entity;

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

    @OneToMany(mappedBy = "cinema", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private List<Showtime> showtimes;

    @Override
    public int compareTo(Cinema o) {
        {
            return this.id.compareTo(o.getId());
        }
    }
}
