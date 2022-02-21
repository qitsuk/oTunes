package dk.qitsuk.otunes.dataaccess.dataaccessobjects;

import dk.qitsuk.otunes.dataaccess.connector.SQLiteDBConnector;
import dk.qitsuk.otunes.dataaccess.models.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAO {
    private ArrayList<Customer> customers;

    public ArrayList<Customer> getAllCustomers() {
        customers = new ArrayList<>();
        String sql = "SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM Customer";
        try (Connection conn = SQLiteDBConnector.getInstance().getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                customers.add(new Customer(
                        rs.getInt("CustomerId"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("Country"),
                        rs.getString("PostalCode"),
                        rs.getString("Phone"),
                        rs.getString("Email")
                ));
            }
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            System.exit(-1);
        }
        return customers;
    }
}
