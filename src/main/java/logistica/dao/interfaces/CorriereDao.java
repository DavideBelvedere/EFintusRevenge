package logistica.dao.interfaces;

import logistica.entities.Corriere;

import java.util.List;

public interface CorriereDao {
    void saveCorriere(Corriere corriere);
    Corriere getById(Integer id_corriere, boolean withRel);
    List<Corriere> getAllCouriers();

}
