package cinema.org.cinema.dao;

import cinema.org.cinema.entities.categorie;
import cinema.org.cinema.entities.cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface categorieRepository extends JpaRepository<categorie,Long> {

}
