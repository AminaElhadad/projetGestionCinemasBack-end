package cinema.org.cinema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ticket implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 75)
    private String nomClient;
    private double prix;
    @Column(unique=true)
    private int codePayement;
    private boolean reservee;
    @ManyToOne
    private projection projection;
    @ManyToOne
    private place place;
}
