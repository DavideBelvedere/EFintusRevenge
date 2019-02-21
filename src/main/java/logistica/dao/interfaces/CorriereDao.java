package logistica.dao.interfaces;

import logistica.entities.Corriere;

public interface CorriereDao {
    boolean saveCorriere(Corriere corriere);
    boolean updateCorriere(Corriere corriere);
    boolean deleteCorriere(int id_corriere);
    Corriere getById(int id_corriere, boolean withRel);
}
