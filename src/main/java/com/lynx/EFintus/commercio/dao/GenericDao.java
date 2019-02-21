package com.lynx.EFintus.commercio.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import com.lynx.EFintus.commercio.interfaces.Dao;

public abstract class GenericDao<T> implements Dao<T> {

    public static Connection getConnection() {
	Connection con = null;
	try {
	    Class.forName("com.mysql.jdbc.Driver");
	    con = DriverManager.getConnection("jdbc:mysql://10.9.129.35:3306/efintus_commerciale", "fintus",
		    "P@ssword2018$");
	} catch (Exception e) {
	    System.out.println(e);
	}
	return con;
    }

    public abstract String getTableName();

    public abstract String getColumns();

    public String getTableAndColumns() {

	return getTableName() + " " + getColumns();
    }
}
