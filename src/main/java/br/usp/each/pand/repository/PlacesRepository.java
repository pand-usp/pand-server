package br.usp.each.pand.repository;

import br.usp.each.pand.model.Place;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class PlacesRepository implements PanacheMongoRepository<Place> {

    public void insertTest(Place place) {
        this.persist(place);
    }

    public List<Place> findByName(String name) {
        return this.find("name like ?1", caseInsensitive(name)).list();
    }

    private String caseInsensitive(String field) {
        return "/" + field + "/i";
    }
}
