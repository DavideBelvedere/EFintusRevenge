package logistica.dao.interfaces;

import logistica.entities.Fornitura;
import logistica.entities.Magazzino;
import logistica.entities.Prodotto;

import java.util.HashMap;
import java.util.List;

public interface ProdottoDao {

    Prodotto getById(Integer id, boolean withRel);

    /***
     *
     * @param id_prodotto the product id that needs to be find
     * @return a list that contains hashMap key: Warehouse value:section of warehouse
     */
    HashMap<Magazzino, Character> getProductLocation(Integer id_prodotto);

    Integer getProductAvailability(Integer id_prodotto);

    List<Fornitura> getSuppliesOfProduct(Integer id_prodotto);


}
