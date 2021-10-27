package br.usp.each.pand.resource;

import br.usp.each.pand.model.Community;
import br.usp.each.pand.service.CommunitiesService;
import org.bson.types.ObjectId;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.beans.ConstructorProperties;
import java.net.URI;

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

    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertTest(Community community) {
        ObjectId id = communitiesService.insertCommunity(community);
        return Response.created(URI.create("/")).build();
    }

}
