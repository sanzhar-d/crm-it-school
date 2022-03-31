package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public interface CrudDao<Model2> {
    Model2 save(Model2 model);
    Model2 findById(Long id);
    List<Model2> getAll();
    Model2 update(Model2 model);

    default Connection getConnection() throws SQLException {
        final String URL = "jdbc:postgresql://localhost:5432/crm-it-school";
        final String USERNAME = "postgres";
        final String PASSWORD = "root";

        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
