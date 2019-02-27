package logistica.rest.endPoint;

import logistica.dao.MagazzinoDaoImpl;
import logistica.rest.request.MagazzinoRequest;
import logistica.rest.response.MagazzinoResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/magazzino")
public class MagazzinoEndPoint {

	private MagazzinoDaoImpl magazzinoDao = new MagazzinoDaoImpl();

    @GET
    @Path("/getAll")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public MagazzinoResponse retrieveAllWarehouse() {
        MagazzinoResponse response = new MagazzinoResponse();
        if( magazzinoDao.getAllWarehouse() == null) {
        	System.out.println("------------------- NULLOO");
        } else {
            System.out.println("---------  Response Magazzino   ------------" + magazzinoDao.getAllWarehouse());

        }
        response.setMagazzini(magazzinoDao.getAllWarehouse());
        return response;
    }

    @POST
    @Path("/getById")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public MagazzinoResponse retrieveById(MagazzinoRequest magazzinoRequest) {
        MagazzinoResponse response = new MagazzinoResponse();
        response.addMagazzini(magazzinoDao.getById(magazzinoRequest.getId()));
        return response;
    }
}
