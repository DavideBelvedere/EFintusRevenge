package logistica.dao.interfaces;

import logistica.entities.Fornitore;
import logistica.entities.Fornitura;

import java.util.List;

public interface FornitoreDao {

    List<Fornitore> getAllSupplier();

    Fornitore getById(Integer id_fornitore,boolean withRel);

    List<Fornitura> getSuppliesFromSupplier(Integer id_fornitore);
}
