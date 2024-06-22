package com.avs.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AvsRepository {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/avs";
    private static final String USERNAME = "avs";
    private static final String PASSWORD = "avspass";

    public Address queryData(int searchPincode) {
        String sql = "SELECT locality, pincode, sub_district, district, state FROM Address WHERE pincode = ?";
        
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
             
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            preparedStatement.setInt(1, searchPincode);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Address address = new Address();
                    address.setLocality(resultSet.getString("locality"));
                    address.setSubDistname(resultSet.getString("sub_district"));
                    address.setDistrictname(resultSet.getString("district"));
                    address.setStateName(resultSet.getString("state"));
                    address.setPincode(resultSet.getInt("pincode"));
                    return address;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Log exception properly, possibly using a logging framework
        }
        return null; // Or throw an appropriate exception
    }
}
