package logistica.rest.endPoint;

import logistica.dao.MagazzinoDaoImpl;
import logistica.entities.Lavoratore;
import logistica.entities.Magazzino;
import logistica.entities.Prodotto;
import logistica.rest.request.MagazzinoRequest;
import logistica.rest.response.ResponsePO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/magazzino")
public class MagazzinoEndPoint {

    private MagazzinoDaoImpl magazzinoDao = new MagazzinoDaoImpl();

    @GET
    @Path("/getAll")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponsePO<Magazzino> retrieveAllWarehouse() {
        ResponsePO<Magazzino> response = new ResponsePO<>();
        response.setResponseList(magazzinoDao.getAllWarehouse());
        return response;
    }

    @POST
    @Path("/getById")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponsePO<Magazzino> retrieveById(MagazzinoRequest magazzinoRequest) {
        ResponsePO<Magazzino> response = new ResponsePO<>();
        response.addResponsePO(magazzinoDao.getById(magazzinoRequest.getId(), false));
        return response;
    }
    @POST
    @Path("/getWorkers")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponsePO<Lavoratore> retrieveWorkersFromWarehouse(MagazzinoRequest magazzinoRequest) {
        ResponsePO<Lavoratore> lavoratoreResponse = new ResponsePO<>();
        lavoratoreResponse.setResponseList(magazzinoDao.getAllWorkersInWarehouse(magazzinoRequest.getId()));
        return lavoratoreResponse;
    }




    @POST
    @Path("/getById")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponsePO<Prodotto> retrieveProductsFromWarehouse(MagazzinoRequest magazzinoRequest) {
        ResponsePO<Prodotto> response = new ResponsePO<>();
        response.setResponseList(magazzinoDao.getAllProductInWarehouse(magazzinoRequest.getId()));
        return response;
    }




}
