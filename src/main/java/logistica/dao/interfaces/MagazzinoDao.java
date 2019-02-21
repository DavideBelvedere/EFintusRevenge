package logistica.dao.interfaces;

import logistica.entities.Lavoratore;
import logistica.entities.Magazzino;
import logistica.entities.Prodotto;

import java.util.List;

public interface MagazzinoDao {

    Magazzino getById(int id);

    List<Prodotto> getAllProductInWarehouse(int id_magazzino);

    List<Lavoratore> getAllWorkersInWarehouse(int id_magazzino);
}
