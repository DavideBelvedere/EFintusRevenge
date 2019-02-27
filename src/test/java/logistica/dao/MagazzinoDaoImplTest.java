package logistica.dao;

import logistica.entities.Magazzino;
import org.junit.Test;

import java.util.List;

public class MagazzinoDaoImplTest {

    @Test
    public void getAllWarehouse() {
        MagazzinoDaoImpl magazzinoDao= new MagazzinoDaoImpl();
        List<Magazzino> magazzini= magazzinoDao.getAllWarehouse();
        System.out.println(magazzini.size());
    }
}