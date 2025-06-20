package pl.edu.pg.Cinemas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
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
    @Column(name = "opening_date")
    private Date openingDate;

    @Override
    public int compareTo(Cinema o) {
        {
            return this.openingDate.compareTo(o.getOpeningDate());
        }
    }
}
