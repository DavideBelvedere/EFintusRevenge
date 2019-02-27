package logistica.dao.interfaces;

import logistica.dao.Utility.JpaDao;
import logistica.entities.Lavoratore;
import logistica.entities.Magazzino;
import logistica.entities.Prodotto;

import java.util.List;

public interface MagazzinoDao{

    Magazzino getById(Integer id, boolean withRel);

    List<Prodotto> getAllProductInWarehouse(Integer id_magazzino);

    List<Lavoratore> getAllWorkersInWarehouse(Integer id_magazzino);

    List<Magazzino> getAllWarehouse();
}
