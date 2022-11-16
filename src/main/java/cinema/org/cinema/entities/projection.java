package cinema.org.cinema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class projection implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date dateProjection;
    private double prix;
    @ManyToOne
    private film film;
    @ManyToOne
    private salle salle;
    @OneToMany(mappedBy = "projection")
    private Collection<ticket> tickets;
    @ManyToOne
    private seance seance;
}
