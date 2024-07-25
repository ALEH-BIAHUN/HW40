package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/stones_test";
        String user = "root";
        String pass = "test";

        try {
            Connection connection = DriverManager.getConnection(dbUrl, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM instructors");
            List<Instructors> instructors = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int salary = resultSet.getInt("salary");
                int age = resultSet.getInt("age");
                instructors.add(new Instructors(id, name, salary, age));
            }
            instructors.forEach(System.out::println);
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}