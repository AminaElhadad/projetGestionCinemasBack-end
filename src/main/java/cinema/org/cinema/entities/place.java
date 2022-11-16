package cinema.org.cinema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class place implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 75)
    private String name;
    private double longitude, latitude, altitude;
    @ManyToOne
    private salle salle;
    @OneToMany(mappedBy = "place")
    private Collection<ticket> tickets;
}
