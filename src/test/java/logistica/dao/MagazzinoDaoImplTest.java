package logistica.dao;

import logistica.dao.interfaces.MagazzinoDao;
import logistica.entities.Magazzino;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MagazzinoDaoImplTest {

    @Test
    public void getAllWarehouse() {
        MagazzinoDaoImpl magazzinoDao= new MagazzinoDaoImpl();
        List<Magazzino> magazzini= magazzinoDao.getAllWarehouse();
        System.out.println();
    }
}