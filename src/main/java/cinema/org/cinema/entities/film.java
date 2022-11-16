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
public class film implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 75)
    private String titre;
    private String description;
    private String realisateur;
    private Date dateSortie;
    private double duree;
    @Column(length = 75)
    private String photo;
    @OneToMany(mappedBy = "film")
    private Collection<projection> projections;
    @ManyToOne
    private categorie categorie;
}
