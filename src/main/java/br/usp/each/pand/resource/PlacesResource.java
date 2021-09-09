package br.usp.each.pand.resource;

import br.usp.each.pand.service.PlacesService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/place")
public class PlacesResource {

    @Inject
    PlacesService placesService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return placesService.testService();
    }
}