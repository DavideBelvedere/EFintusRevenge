package logistica.rest.endPoint;

import logistica.dao.ProdottoDaoImpl;
import logistica.rest.request.ProdottoRequest;
import logistica.rest.response.ProdottoResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/prodotto")
public class ProdottoEndPoint {

    private ProdottoDaoImpl prodottoDao = new ProdottoDaoImpl();


    @POST
    @Path("/getById")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ProdottoResponse retrieveById(ProdottoRequest prodottoRequest) {
        ProdottoResponse response = new ProdottoResponse();
        response.addResponsePO(prodottoDao.getById(prodottoRequest.getId(), false));
        return response;
    }

    @POST
    @Path("/getProductLocation")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ProdottoResponse getProductLocation(ProdottoRequest prodottoRequest){
        ProdottoResponse response = new ProdottoResponse();
        response.setLocazione(prodottoDao.getProductLocation(prodottoRequest.getId()));
        return response;
    }

    @POST
    @Path("/getProductAvailability")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ProdottoResponse getProductAvailability(ProdottoRequest prodottoRequest){
        ProdottoResponse response = new ProdottoResponse();
        response.setQuantita(prodottoDao.getProductAvailability(prodottoRequest.getId()));
        return response;
    }
}
