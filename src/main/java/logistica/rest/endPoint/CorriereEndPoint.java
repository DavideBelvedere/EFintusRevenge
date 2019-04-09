package logistica.rest.endPoint;

import logistica.dao.CorriereDaoImpl;
import logistica.entities.Corriere;
import logistica.rest.request.CorriereRequest;
import logistica.rest.response.ResponsePO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/corriere")
public class CorriereEndPoint {

    private CorriereDaoImpl corriereDao = new CorriereDaoImpl();

    @GET
    @Path("/getAll")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponsePO<Corriere> retrieveAllWarehouse() {
        ResponsePO<Corriere> response = new ResponsePO<>();
        response.setResponseList(corriereDao.getAllCouriers());
        return response;
    }

    @POST
    @Path("/persist")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void retrieveWorkersFromWarehouse(CorriereRequest corriereRequest) {
        corriereDao.persist(corriereRequest.translateInOrmObjectForPersist(false));
    }
}
