package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.HazardDTO;
import errorhandling.NotFoundException;
import facades.HazardFacade;
import utils.EMF_Creator;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.util.List;

@Path("hazard")
    public class HazardResource {
        private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
        private HazardFacade hazardFacade = HazardFacade.getHazardFacade(EMF);

        @Context
        private UriInfo context;


        @GET
//    @RolesAllowed("user")
        @Produces(MediaType.APPLICATION_JSON)
        public Response getAllHazards() throws IOException {
            List<HazardDTO> hazardDTOs = hazardFacade.getAllHazards();
            return Response.ok().entity(GSON.toJson(hazardDTOs)).build();
        }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @RolesAllowed("user")
    public Response createHazard(String content){
        HazardDTO hdto = GSON.fromJson(content, HazardDTO.class);
        HazardDTO newHdto = hazardFacade.createHazard(hdto);
        return Response.ok().entity(GSON.toJson(newHdto)).build();
    }
    @DELETE
    @Path("/delete/{id}")
    @RolesAllowed("admin")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response delteHazard(@PathParam("id") int id){
        hazardFacade.deleteHazard(id);
        return Response.ok().entity("Deleted").build();
    }
}
