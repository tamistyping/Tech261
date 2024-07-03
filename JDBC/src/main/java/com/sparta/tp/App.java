package com.sparta.tp;
import java.sql.*;

public class App {

    public static void main(String[] args) throws SQLException {

        DatabaseConnection.getConnection();

        CustomersDAO customersDAO = new CustomersDAO();
//        customersDAO.printAllCustomers();
        customersDAO.printCustomerByName("Maria Anders");
    }
}
