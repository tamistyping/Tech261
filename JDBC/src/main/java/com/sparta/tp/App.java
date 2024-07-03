package com.sparta.tp;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class App {
    //connection
    //statements
    //results
    public static void main(String[] args) {

        Properties properties = new Properties();

        try {
            properties.load(new FileReader("src/main/resources/mySQL.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection(
                    properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password")
            );

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM northwind.customers WHERE CustomerName = ?");
            preparedStatement.setString(1, "Manish");

            System.out.println("Successfully connected to DB");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM northwind.customers");

            while(resultSet.next()){
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
                System.out.println("\n");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
