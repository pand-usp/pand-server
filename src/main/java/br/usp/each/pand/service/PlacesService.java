package br.usp.each.pand.service;


import br.usp.each.pand.model.Place;
import br.usp.each.pand.repository.PlacesRepository;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PlacesService {

    PlacesRepository places;

    @Inject
    public PlacesService(PlacesRepository places) {
        this.places = places;
    }


    public ObjectId insertPlace(Place place) {
        ObjectId id = new ObjectId();
        place.id = id;
        places.insertPlace(place);
        return id;
    }

    public List<Place> listAll() {
        return places.findAll().list();
    }

    public List<Place> findPlaces(String query) {
        return places.findByName(query);
    }

    public Place findPlaceById(String id) {
        Optional<Place> maybePlace = places.findByIdOptional(new ObjectId(id));
        return maybePlace.orElseThrow(() -> new NotFoundException("Could not find id: " + id));
    }
}
