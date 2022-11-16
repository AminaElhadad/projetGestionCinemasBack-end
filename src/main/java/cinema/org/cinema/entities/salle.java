package cinema.org.cinema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class salle implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column(length = 75)
   private String name;
   private int nombrePlaces;
   @ManyToOne
   private cinema cinema;
   @OneToMany(mappedBy = "salle")
   private Collection<place> places;
   @OneToMany(mappedBy = "salle")
   private Collection<projection> projections;
}
