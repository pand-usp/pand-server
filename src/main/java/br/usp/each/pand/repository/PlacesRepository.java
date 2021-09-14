package br.usp.each.pand.repository;

import br.usp.each.pand.model.Place;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PlacesRepository implements PanacheMongoRepository<Place> {

    public void insertTest(Place place) {
        this.persist(place);
    }

    public String test() {
        return "test MVC";
    }
}
