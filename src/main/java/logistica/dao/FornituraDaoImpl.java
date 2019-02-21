package logistica.dao;

import com.lynx.EFintus.logistica.Utility.Em;
import com.lynx.EFintus.logistica.dao.interfaces.FornituraDao;
import com.lynx.EFintus.logistica.entities.Fornitura;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class FornituraDaoImpl implements FornituraDao {

    @Override
    public Fornitura getById(int id) {
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
