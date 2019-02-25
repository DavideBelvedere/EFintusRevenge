package restServicesConf;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import logistica.rest.endPoint.MagazzinoEndPoint;

import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class RestEasyServices extends Application {
    private Set<Object> singletons = new HashSet<Object>();

    //aggiungere tutte le classi che espongono servizi al singleton
    public RestEasyServices() {
    	singletons.add(new MagazzinoEndPoint());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
