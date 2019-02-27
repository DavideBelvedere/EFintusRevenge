package logistica.dao.interfaces;

import logistica.entities.Fornitura;
import logistica.entities.Magazzino;
import logistica.entities.Prodotto2;

import java.util.HashMap;
import java.util.List;

public interface ProdottoDao {

    Prodotto2 getById(int id);

    /***
     *
     * @param id_prodotto the product id that needs to be find
     * @return a list that contains hashMap key: Warehouse value:section of warehouse
     */
    HashMap<Magazzino, Character> getProductLocation(int id_prodotto);

    int getProductAvailability(int id_prodotto);

    List<Fornitura> getSuppliesOfProduct(int id_prodotto);
}
