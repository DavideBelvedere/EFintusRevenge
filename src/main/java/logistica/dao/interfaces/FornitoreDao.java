package logistica.dao.interfaces;

import logistica.entities.Fornitore;
import logistica.entities.Fornitura;

import java.util.List;

public interface FornitoreDao {
    Fornitore getById(int id_fornitore);

    List<Fornitura> getSuppliesFromSupplier(int id_fornitore);
}
