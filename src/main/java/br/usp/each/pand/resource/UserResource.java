package br.usp.each.pand.resource;

import br.usp.each.pand.model.User;
import br.usp.each.pand.service.UserService;
import org.jboss.resteasy.annotations.Form;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.Optional;

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

    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response login(@FormParam("username") String username, @FormParam("password") String password) {
        try {
            if (null == username || null == password || username.isEmpty() || password.isEmpty()) {
                return Response.status(400)
                        .entity("username and password invalid")
                        .build();
            }

            Optional<User> maybeUser = userService.login(username, password);
            if (maybeUser.isPresent()) {
                return Response.status(200).entity(maybeUser.get()).build();
            } else {
                return Response.status(404).entity("user not found").build();
            }

        } catch (Exception e) {
            return Response.status(500)
                    .entity("Unexpected error")
                    .build();
        }
    }

}
