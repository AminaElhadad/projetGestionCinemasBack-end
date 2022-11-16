package cinema.org.cinema.dao;

import cinema.org.cinema.entities.cinema;
import cinema.org.cinema.entities.place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface placeRepository extends JpaRepository<place,Long> {

}
