package br.usp.each.pand.service;


import br.usp.each.pand.model.Place;
import br.usp.each.pand.repository.PlacesRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class PlacesService {

    PlacesRepository places;

    @Inject
    public PlacesService(PlacesRepository places) {
        this.places = places;
    }


    public void insertTest(Place place) {
        places.insertTest(place);
    }

    public List<Place> listAll() {
        return places.findAll().list();
    }

    public List<Place> findPlaces(String query) {
        return places.findByName(query);
    }
}
