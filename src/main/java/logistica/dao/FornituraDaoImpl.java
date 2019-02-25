package logistica.dao;

import logistica.Utility.Em;
import logistica.dao.interfaces.FornituraDao;
import logistica.entities.Fornitura;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class FornituraDaoImpl implements FornituraDao {

    @Override
    public Fornitura getById(Integer id) {
        EntityManager em = Em.createEntityManager();
        Fornitura fornitura = em.find(Fornitura.class, id);
        Em.closeEntityManager(em);
        return fornitura;
    }

    @Override
    public List<Fornitura> getSuppliesByDate(Date date) {
        EntityManager em = Em.createEntityManager();
        Query query = em.createQuery("select f From Fornitura f WHERE f.date=:date");
        query.setParameter("date", date);
        List results = query.getResultList();
        Em.closeEntityManager(em);
        if (!results.isEmpty()) {
            return results;
        }
        return null;
    }
}
