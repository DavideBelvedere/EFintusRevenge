package logistica.dao;

import logistica.dao.SuperDao.JpaDao;
import logistica.dao.interfaces.FornitoreDao;
import logistica.entities.Fornitore;
import logistica.entities.Fornitura;

import java.util.List;

public class FornitoreDaoImpl extends JpaDao<Fornitore, Integer> implements FornitoreDao {

    private String baseQueryNoRel = "SELECT NEW Fornitore(f.id, f.name, f.via, f.citta, f.n_civico, f.cap) FROM Fornitore f"; //JOIN FETCH c.ordini

    private String baseQueryWithRel = "SELECT f from Fornitore f JOIN FETCH f.forniture";

    public FornitoreDaoImpl() {
        super(Fornitore.class);
    }

    @Override
    public List<Fornitore> getAllSupplier() {
        return getAll(baseQueryNoRel);
    }

    @Override
    public Fornitore getById(Integer id_fornitore, boolean withrel) {
        String queryString;
        if (withrel) {
            queryString = baseQueryWithRel;
        } else {
            queryString = baseQueryNoRel;
        }
        queryString += " WHERE f.id=:id";

        return getByIdQuery(queryString, id_fornitore);

    }


    @Override
    public List<Fornitura> getSuppliesFromSupplier(Integer id_fornitore) {
        Fornitore fornitore = getById(id_fornitore, true);
        if (fornitore != null && fornitore.getForniture() != null) {
            return fornitore.getForniture();
        }
        return null;
    }
}
