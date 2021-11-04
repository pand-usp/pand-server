package br.usp.each.pand.resource;

import br.usp.each.pand.model.User;
import br.usp.each.pand.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    UserService userService;

    @Inject
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(User user){
        try {
            userService.register(user);
        }catch (Exception e) {
            return Response.status(500)
                    .entity("Error :c")
                    .build();
        }
        return Response.status(201).build();
    }


}
