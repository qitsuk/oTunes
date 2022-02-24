package dk.qitsuk.otunes.dataaccess.dataaccessobjects;

import dk.qitsuk.otunes.dataaccess.connector.SQLiteDBConnector;
import dk.qitsuk.otunes.dataaccess.models.CountryCount;
import dk.qitsuk.otunes.dataaccess.models.Customer;
import dk.qitsuk.otunes.service.ConnectionFactory;
import dk.qitsuk.otunes.service.DatabaseConnectionFactory;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import



@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    private final DatabaseConnectionFactory connectionFactory;

    public CustomerRepositoryImpl(DatabaseConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    private Collection<Customer> processResultSet(ResultSet resultSet) throws SQLException {
        ArrayList<Customer> customers = new ArrayList();

        while(resultSet.next()) {
            Customer customer = new Customer(
                    resultSet.getInt("id"),
                    resultSet.getString("firstName"),
                    resultSet.getString("lastName"),
                    resultSet.getString("country"),
                    resultSet.getString("postalCode"),
                    resultSet.getString("phoneNumber"),
                    resultSet.getString("email")

            );

            customers.add(customer);
        }

        return customers;
    }

    public Collection<Customer> getAllCustomers() {
        try (Connection conn = ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM Customer");
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return processResultSet(resultSet);
            }

        } catch (SQLException sqe) {
            sqe.printStackTrace();
            return null;
        }
    }

    public Customer getById (String id) {
        try (Connection conn = connectionFactory.getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM Customer WHERE " + "CustomerId=?");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            return new Customer(
                    resultSet.getInt("Id"),
                    resultSet.getString("firstName"),
                    resultSet.getString("Lastname"),
                    resultSet.getString("Country"),
                    resultSet.getString("PostalCode"),
                    resultSet.getString("Phone"),
                    resultSet.getString("Email")

            );

        } catch (SQLException sqe) {
            sqe.printStackTrace();
            return null;
        }
    }


    public ArrayList<Customer> getCustomerSection(int offset, int limit) {
        customerSection = new ArrayList<>();
        String sql = "SELECT * FROM Customer ORDER BY CustomerID LIMIT ?, ?";
        try {
            conn = SQLiteDBConnector.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, offset);
            ps.setInt(2, limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                customerSection.add(customer = new Customer(
                        rs.getInt("id"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("Country"),
                        rs.getString("PostalCode"),
                        rs.getString("Phone"),
                        rs.getString("Email")
                ));
                customer.setId(rs.getInt("CustomerId"));
            }
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            System.exit(-1);
        } finally {
            try {
                conn.close();
            } catch (SQLException sqe) {
                sqe.printStackTrace();
                System.exit(-1);
            }
        }
        return customerSection;
    }

    public Customer updateCustomerById(Customer customer, int id) {
        String sql = "UPDATE Customer set FirstName=?, LastName=?, Country=?, PostalCode=?, Phone=?, Email=? WHERE CustomerId=? ";
        try {
            conn = SQLiteDBConnector.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getCountry());
            ps.setString(4, customer.getPostalCode());
            ps.setString(5, customer.getPhoneNumber());
            ps.setString(6, customer.getEmail());
            ps.setInt(7, id);
            ps.executeUpdate();
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            System.exit(-1);
        } finally {
            try {
                conn.close();
            } catch (SQLException sqe) {
                sqe.printStackTrace();
                System.exit(-1);
            }
        }
        return customer;
    }

    public ArrayList<Customer> numCustomerCountry() {
        ArrayList<CountryCount> countryCountList = new ArrayList<>();
        String sql = "SELECT COUNT(CustomerId) AS NumberOfCustomers, Country FROM Customer GROUP BY Country ORDER BY COUNT(CustomerId) DESC";
        try {
            conn = SQLiteDBConnector.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                countryCountList.add(new CountryCount(
                        rs.getInt("NumberOfCustomers"),
                        rs.getString("Country")
                ));
            }
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            System.exit(-1);
        } finally {
            try {
                conn.close();
            } catch (SQLException sqe) {
                sqe.printStackTrace();
                System.exit(-1);
            }
        }
        return countryCountList;
    }

    @Override
    public Customer updateCustomerById(int id) {
        return null;
    }

}
