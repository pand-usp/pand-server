package br.usp.each.pand.resource;

import br.usp.each.pand.model.Community;
import br.usp.each.pand.service.CommunitiesService;
import org.bson.types.ObjectId;
import org.jboss.resteasy.annotations.Form;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.beans.ConstructorProperties;
import java.net.URI;
import java.util.List;

@Path("/community")
@Produces(MediaType.APPLICATION_JSON)
public class CommunitiesResource {

    @Inject
    CommunitiesService communitiesService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findCommunityById(@PathParam("id") String id){
        try {

            Community community = communitiesService.findCommunityById(id);
            return Response.ok()
                    .entity(community)
                    .build();
        } catch (NotFoundException e) {
            return Response.status(404)
                    .entity("Community not found")
                    .build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listCommunities() {
        List<Community> communities = communitiesService.listCommunities();
        return Response.ok()
                .entity(communities)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(Community community) {
        communitiesService.insertCommunity(community);
        return Response.created(URI.create("/")).build();
    }

    @PUT
    @Path("/place")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response addPlace(@FormParam("placeId") String id) {
        communitiesService.addPlace(id);
        return Response.ok().build();
    }

}
