package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.HazardDTO;
import facades.HazardFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
}
