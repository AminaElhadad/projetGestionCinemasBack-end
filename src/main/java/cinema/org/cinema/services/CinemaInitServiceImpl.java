package cinema.org.cinema.services;

import cinema.org.cinema.dao.*;
import cinema.org.cinema.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.*;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service
public class CinemaInitServiceImpl implements  ICinemaInitService{

    @Autowired
    private villeRepository villeRepository;
    @Autowired
    private cinemaRepository cinemaRepository;
    @Autowired
    private salleRepository salleRepository;
    @Autowired
    private placeRepository placeRepository;
    @Autowired
    private categorieRepository categorieRepository;
    @Autowired
    private filmRepository filmRepository;
    @Autowired
    private projectionRepository projectionRepository;
    @Autowired
    private seanceRepository seanceRepository;
    @Autowired
    private ticketRepository ticketRepository;


    @Override
    public void initVilles() {
        Stream.of("Casablanca","Marrakech","Rabat","Tanger").forEach(nameVille->{
            ville v=new ville();
            v.setName(nameVille);
            villeRepository.save(v);
        });
    }

    @Override
    public void initCinemas() {
        villeRepository.findAll().forEach(v->{
            Stream.of("MEGARAMA","IMAX","FOUNOUN","CHAHRAZAD","DAOULIZ").forEach(nameCinema->{
                cinema c=new cinema();
                c.setName(nameCinema);
                c.setNombreSalles(3+(int)Math.random()*7);
                c.setVille(v);
                cinemaRepository.save(c);
            });
        });
    }

    @Override
    public void initSalles() {
       cinemaRepository.findAll().forEach(c->{
           for (int i=0;i<c.getNombreSalles();i++){
               salle s=new salle();
               s.setName("Salle"+(i+1));
               s.setCinema(c);
               s.setNombrePlaces(15+(int)Math.random()*20);
               salleRepository.save(s);
           }
       });
    }

    @Override
    public void initPlaces() {
        salleRepository.findAll().forEach(s->{
            for (int i=0;i<s.getNombrePlaces();i++){
                place p=new place();
                p.setNumero(i+1);
                p.setSalle(s);
                placeRepository.save(p);
            }
        });
    }

    @Override
    public void initSeances() {
        DateFormat dateFormat=new SimpleDateFormat("HH:mm");
         Stream.of("12:00","15:00","17:00","19:00","21:00").forEach(heureSeance->{
             seance seance=new seance();
             try {
                 seance.setHeureDebut(dateFormat.parse(heureSeance));
                 seanceRepository.save(seance);
             } catch (ParseException e) {
                 throw new RuntimeException(e);
             }

         });
    }

    @Override
    public void initCategories() {
         Stream.of("Histoire","Actions","Fiction","Drama").forEach(nomCategorie->{
             categorie categorie =new categorie();
             categorie.setNom(nomCategorie);
             categorieRepository.save(categorie);
         });
    }

    @Override
    public void initFilms() {
        double[] durees=new double[] {1,1.5,2,2.5,3};
        List<categorie> categories= categorieRepository.findAll();
       Stream.of("A Werewolf Boy","Ralph Breaks The Internet","The Dictator","Your Name","Flavors of Youth","Annabelle","La Ligne Verte")
               .forEach(titreFilm->{
                      film f=new film();
                      f.setTitre(titreFilm);
                      f.setDuree(durees[new Random().nextInt(durees.length)]);
                      f.setPhoto(titreFilm.replaceAll(" ",""));
                      f.setCategorie(categories.get(new Random().nextInt(categories.size())));
                      filmRepository.save(f);
               });
    }

    @Override
    public void initProjections() {

    }

    @Override
    public void initTickets() {

    }
}
