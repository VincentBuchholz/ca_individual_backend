package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.CarDTO;
import dtos.HazardDTO;
import errorhandling.NotFoundException;
import facades.CarFacade;
import facades.HazardFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.util.List;

@Path("car")
public class CarResource {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private CarFacade carFacade = new CarFacade();

    @Context
    private UriInfo context;


    @GET
//    @RolesAllowed("user")
    @Path("/{numberplate}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCarByNumberPlate(@PathParam("numberplate") String numberplate) throws IOException {
        CarDTO carDTO = carFacade.getCarByNumberPlate(numberplate);
        return Response.ok().entity(GSON.toJson(carDTO)).build();
    }

}
