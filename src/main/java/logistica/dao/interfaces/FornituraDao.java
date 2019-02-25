package logistica.dao.interfaces;

import logistica.entities.Fornitura;

import java.util.Date;
import java.util.List;

public interface FornituraDao {
    Fornitura getById(Integer id);

    List<Fornitura> getSuppliesByDate(Date date);
}