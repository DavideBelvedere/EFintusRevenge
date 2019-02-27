package com.lynx.EFintus.commercio.dao;


import com.lynx.EFintus.commercio.classes.Categoria;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

public class CategorieDaoTest {

    @Test
    public void getAllTest()
    {
        CategorieDao dao = new CategorieDao();

        try {
            List<Categoria> categorie =  dao.getAll();
            for(Categoria c : categorie){
                System.out.println(c.getId());
            }
        } catch (SQLException e) {
            fail();
        }


    }
}
