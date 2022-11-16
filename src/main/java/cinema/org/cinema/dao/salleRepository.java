package cinema.org.cinema.dao;

import cinema.org.cinema.entities.cinema;
import cinema.org.cinema.entities.salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface salleRepository extends JpaRepository<salle,Long> {

}
