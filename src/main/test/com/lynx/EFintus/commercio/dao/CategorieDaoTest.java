package com.lynx.EFintus.commercio.dao;


import com.lynx.EFintus.commercio.classes.Categoria;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class CategorieDaoTest {

    @Test
    public void getAllAndSaveTest()
    {
        CategorieDao dao = new CategorieDao();
        int firstReadCount = 0;
        int secondReadCount = 0;
        try {
            List<Categoria> categorie =  dao.getAll();
            for(Categoria c : categorie){
                System.out.println(c.getId());
            }

            firstReadCount = categorie.size();
            System.out.println("first read: " + firstReadCount);

        } catch (SQLException e) {
            fail();
        }



        try
        {
            Categoria cat = new Categoria();
            cat.setNome("Animali");
            dao.save(cat);
            List<Categoria> categorie2 =  dao.getAll();
            secondReadCount = categorie2.size();
            System.out.println("second read: " + secondReadCount);
        } catch (SQLException e) {
            fail();
        }

        assertEquals(firstReadCount,(secondReadCount - 1));


    }
}
