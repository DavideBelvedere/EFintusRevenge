package logistica.dao;

import logistica.dao.SuperDao.JpaDao;
import logistica.dao.interfaces.MagazzinoDao;
import logistica.entities.Disponibilita;
import logistica.entities.Lavoratore;
import logistica.entities.Magazzino;
import logistica.entities.Prodotto;

import java.util.ArrayList;
import java.util.List;

public class MagazzinoDaoImpl extends JpaDao<Magazzino, Integer> implements MagazzinoDao {

    private String baseQueryNoRel = "SELECT NEW Magazzino(m.id,m.via,m.citta,m.n_civico,m.cap,m.metratura,m.altezza,m.capacita,m.nome) FROM Magazzino m"; //JOIN FETCH c.ordini

    private String baseQueryWithRel = "SELECT m from Magazzino m JOIN FETCH m.lavoratori";

    public MagazzinoDaoImpl() {
        super(Magazzino.class);
    }


    @Override
    public Magazzino getById(Integer id, boolean withrel) {
        String queryString;
        if (withrel) {
            queryString = baseQueryWithRel;
        } else {
            queryString = baseQueryNoRel;
        }
        queryString += " WHERE m.id=:id";
        return getByIdQuery(queryString, id);



    }

    @Override
    public List<Prodotto> getAllProductInWarehouse(Integer id_magazzino) {
        Magazzino magazzino = getById(id_magazzino, true);
        if (magazzino != null && magazzino.getDisponibilita() != null) {
            List<Prodotto> prodotti = new ArrayList<>();
            for (Disponibilita disponibilita : magazzino.getDisponibilita()) {
                if (disponibilita.getProdotto() != null) {
                    prodotti.add(disponibilita.getProdotto());
                }
            }
            if (prodotti.size() > 0) {
                return prodotti;
            }

        }
        return null;
    }


    @Override
    public List<Lavoratore> getAllWorkersInWarehouse(Integer id_magazzino) {
        Magazzino magazzino = getById(id_magazzino, true);
        if (magazzino != null && magazzino.getLavoratori() != null) {
            return magazzino.getLavoratori();
        }
        return null;
    }

    @Override
    public List<Magazzino> getAllWarehouse() {

        return getAll(baseQueryNoRel);
    }


}
