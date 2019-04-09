package logistica.rest.endPoint;

import logistica.dao.FornitoreDaoImpl;
import logistica.entities.Fornitore;
import logistica.rest.response.ResponsePO;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/fornitore")
public class FornitoreEndPoint {

    private FornitoreDaoImpl fornitoreDao = new FornitoreDaoImpl();

    @GET
    @Path("/getAll")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponsePO<Fornitore> retrieveAllWarehouse() {
        ResponsePO<Fornitore> response = new ResponsePO<>();
        response.setResponseList(fornitoreDao.getAllSupplier());
        return response;
    }
}
