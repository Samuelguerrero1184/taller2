package services;

import model.*;
import providers.UserProvider;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("user")
public class UserServices {

    @POST
    @Path("create")
    @Produces("application/json")
    @Consumes("application/json")
    public Response createUser(User user){
        try{
            UserProvider provider = new UserProvider();
            provider.create(user);
            return Response
                    .status(200)
                    .entity(new Message("info","Completado"))
                    .build();
        }catch (Exception e){
            return Response
                    .status(500)
                    .entity(new Message("Exception", e.getMessage()))
                    .build();
        }
    }

    @GET
    @Path("history/{user}")
    @Produces("application/json")
    public Response getHistory(@PathParam("user") String user){
        try{
            UserProvider provider = new UserProvider();
            Historial historial = provider.getInfo(user);
            return Response
                    .status(200)
                    .entity(historial)
                    .build();
        }catch (Exception e){
            return Response
                    .status(500)
                    .entity(new Message("Exception", e.getMessage()))
                    .build();
        }
    }
}