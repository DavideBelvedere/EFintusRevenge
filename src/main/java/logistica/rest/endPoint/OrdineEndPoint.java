package logistica.rest.endPoint;

import logistica.dao.OrdineDaoImpl;
import logistica.entities.Ordine;
import logistica.rest.response.ResponsePO;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ordine")
public class OrdineEndPoint {
    private OrdineDaoImpl ordineDao = new OrdineDaoImpl();

    @GET
    @Path("/getAll")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponsePO<Ordine> getAll() {
        ResponsePO<Ordine> response = new ResponsePO<>();
        response.setResponseList(ordineDao.getAllOrders());
        return response;
    }
}
