package restServicesConf;

import logistica.rest.endPoint.*;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class RestEasyServices extends Application {
    private Set<Object> singletons = new HashSet<Object>();

    //aggiungere tutte le classi che espongono servizi al singleton
    public RestEasyServices() {
        singletons.add(new MagazzinoEndPoint());
        singletons.add(new OrdineEndPoint());
        singletons.add(new FornitoreEndPoint());
        singletons.add(new CorriereEndPoint());
        singletons.add(new ProdottoEndPoint());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
