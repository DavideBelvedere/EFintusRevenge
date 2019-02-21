package logistica.dao.interfaces;

import logistica.entities.Lavoratore;
import logistica.entities.Magazzino;
import logistica.entities.Permesso;

import java.util.List;

public interface LavoratoreDao {
    Lavoratore getById(String codice_fiscale);

    Magazzino getWorkerWarehouse(String codice_fiscale);

    List<Permesso> getWorkerAuthorization(String codice_fiscale);
}
