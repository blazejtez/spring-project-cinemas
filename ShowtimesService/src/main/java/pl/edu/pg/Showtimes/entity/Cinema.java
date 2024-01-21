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

    @Override
    public int compareTo(Cinema o) {
        {
            return this.id.compareTo(o.getId());
        }
    }
}
