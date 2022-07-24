package com.mber.study.javaee.husivm._06_jpa._118_jdbc;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        var url = "jdbc:postgresql://localhost:5432/postgres";
        var user = "postgres";
        var password = "postgres";
        try (var connection = DriverManager.getConnection(url, user, password);
             var statement = connection.createStatement()) {
            connection.setSchema("study_javaee_husivm");
            statement.executeUpdate("DROP TABLE IF EXISTS _118_STUDENT");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS _118_STUDENT(id SERIAL PRIMARY KEY, name VARCHAR(40))");
            statement.executeUpdate("INSERT INTO _118_STUDENT (id, name) VALUES (DEFAULT, 'Mike')");
            statement.executeUpdate("INSERT INTO _118_STUDENT (id, name) VALUES (DEFAULT, 'Elen')");
            statement.executeUpdate("INSERT INTO _118_STUDENT (id, name) VALUES (DEFAULT, 'Hank')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
