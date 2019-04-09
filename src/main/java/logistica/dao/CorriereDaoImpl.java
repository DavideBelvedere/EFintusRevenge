package logistica.dao;

import logistica.dao.SuperDao.JpaDao;
import logistica.dao.interfaces.CorriereDao;
import logistica.entities.Corriere;

import java.util.List;

public class CorriereDaoImpl extends JpaDao<Corriere, Integer> implements CorriereDao {

    private String baseQueryNoRel = "SELECT NEW Corriere(c.id,c.nome, c.via, c.citta, c.n_civico, c.cap) FROM Corriere c"; //JOIN FETCH c.ordini

    private String baseQueryWithRel = "SELECT c from Corriere c JOIN FETCH c.ordini";

    public CorriereDaoImpl() {
        super(Corriere.class);
    }


    @Override
    public void saveCorriere(Corriere corriere) {
    }


    @Override
    public Corriere getById(Integer id_corriere, boolean withRel) {
        String queryString;
        if (withRel) {
            queryString = baseQueryWithRel;
        } else {
            queryString = baseQueryNoRel;
        }
        queryString += " WHERE c.id=:id";
        return getByIdQuery(queryString, id_corriere);


    }

    @Override
    public List<Corriere> getAllCouriers() {
        return getAll(baseQueryNoRel);
    }
}
