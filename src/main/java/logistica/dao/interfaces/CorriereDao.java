package logistica.dao.interfaces;

import logistica.entities.Corriere;

public interface CorriereDao {
    boolean saveCorriere(Corriere corriere);
    boolean updateCorriere(Corriere corriere);
    boolean deleteCorriere(Integer id_corriere);
    Corriere getById(Integer id_corriere, boolean withRel);
}
