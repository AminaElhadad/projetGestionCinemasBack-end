package cinema.org.cinema.dao;

import cinema.org.cinema.entities.cinema;
import cinema.org.cinema.entities.ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ticketRepository extends JpaRepository<ticket,Long> {

}
