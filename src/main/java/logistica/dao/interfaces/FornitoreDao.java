package logistica.dao.interfaces;

import logistica.entities.Fornitore;
import logistica.entities.Fornitura;

import java.util.List;

public interface FornitoreDao {
    Fornitore getById(Integer id_fornitore);

    List<Fornitura> getSuppliesFromSupplier(Integer id_fornitore);
}
