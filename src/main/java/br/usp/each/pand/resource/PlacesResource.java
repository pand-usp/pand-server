package br.usp.each.pand.resource;

import br.usp.each.pand.model.Place;
import br.usp.each.pand.service.PlacesService;
import org.bson.types.ObjectId;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/place")
@Produces(MediaType.APPLICATION_JSON)
public class PlacesResource {

    @Inject
    PlacesService placesService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Place> getPlaces(@QueryParam("q") String query) {
        return placesService.findPlaces(query);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findPlaceById(@PathParam("id") String id) {
        try {

            Place place = placesService.findPlaceById(id);
            return Response.ok()
                    .entity(place)
                    .build();
        } catch (NotFoundException e) {
            return Response.status(404)
                    .entity("Place not found")
                    .build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertTest(Place place) {
        ObjectId id = placesService.insertPlace(place);
        return Response.created(URI.create("/" + id)).build();
    }
}