package avs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class MySQLExample {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/avs"; // Replace with your database URL
        String username = "avs"; // Replace with your database username
        String password = "avspass"; // Replace with your database password

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            
            
            int searchPincode = 500001; // Replace with the pincode you want to search for

            String sql = "SELECT locality, pincode, sub_district, district, state FROM Address WHERE pincode = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, searchPincode);

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            // Process the result set
            while (resultSet.next()) {
                String locality = resultSet.getString("locality");
                int pincode = resultSet.getInt("pincode");
                String subDistname = resultSet.getString("sub_district");
                String districtname = resultSet.getString("district");
                String stateName = resultSet.getString("state");

                // Print the result
                System.out.println("Locality: " + locality + ", Pincode: " + pincode +
                                   ", Sub-district: " + subDistname + ", District: " + districtname +
                                   ", State: " + stateName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
