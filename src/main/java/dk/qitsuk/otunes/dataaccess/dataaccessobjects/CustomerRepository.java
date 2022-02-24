package dk.qitsuk.otunes.dataaccess.dataaccessobjects;

import dk.qitsuk.otunes.dataaccess.connector.SQLiteDBConnector;
import dk.qitsuk.otunes.dataaccess.models.CountryCount;
import dk.qitsuk.otunes.dataaccess.models.Customer;
import dk.qitsuk.otunes.dataaccess.models.CustomerGenre;
import dk.qitsuk.otunes.dataaccess.models.CustomerSpender;

import java.sql.*;
import java.util.ArrayList;

public class CustomerRepository {
    private ArrayList<Customer> customers;
    private ArrayList<Customer> customerSection;
    private Connection conn;
    private Customer customer;

    public ArrayList<Customer> getAllCustomers() {

        customers = new ArrayList<>();
        String sql = "SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM Customer";
        try {
            conn = SQLiteDBConnector.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                customers.add(customer = new Customer(
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
        return customers;
    }

    public Customer getCustomerById(int id) {
        String sql = "SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM Customer WHERE " +
                "CustomerId=?";
        try {
            conn = SQLiteDBConnector.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, String.valueOf(id));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                customer = new Customer(
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("Country"),
                        rs.getString("PostalCode"),
                        rs.getString("Phone"),
                        rs.getString("Email")
                );
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
        return customer;
    }

    public Customer getCustomerByName(String firstName, String lastName) {
        String sql = "SELECT * FROM Customer WHERE FirstName=? AND LastName=?";

        try {
            conn = SQLiteDBConnector.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                customer = new Customer(
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("Country"),
                        rs.getString("PostalCode"),
                        rs.getString("Phone"),
                        rs.getString("Email")
                );
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
        return customer;
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

    public Customer addCustomer(Customer customer) {
        String sql = "Insert into Customer (FirstName, LastName, Country, PostalCode, Phone, Email) VALUES (?,?,?,?,?,?)";
        try {
            conn = SQLiteDBConnector.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getCountry());
            ps.setString(4, customer.getPostalCode());
            ps.setString(5, customer.getPhoneNumber());
            ps.setString(6, customer.getEmail());
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


    public ArrayList<CountryCount> numCustomerCountry() {
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

    public ArrayList<CustomerSpender> customerSpender() {
        ArrayList<CustomerSpender> customerSpenderList = new ArrayList<>();
        String sql = "SELECT FirstName, LastName, I.Total FROM Customer\n" +
                "INNER JOIN Invoice I on Customer.CustomerId = I.CustomerId\n" +
                "ORDER BY Total DESC;";
        try {
            conn = SQLiteDBConnector.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                customerSpenderList.add(new CustomerSpender(
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getFloat("total")
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
        return customerSpenderList;
    }

    public ArrayList<CustomerGenre> customerGenre() {
        ArrayList<CustomerGenre> customerGenreList = new ArrayList<>();
        String sql = "SELECT COUNT(G.Name) AS MostPopular, G.Name FROM Genre AS G\n" +
                " INNER JOIN Track T ON T.GenreId = G.GenreId\n" +
                " INNER JOIN InvoiceLine IL on T.TrackId = IL.TrackId\n" +
                " INNER JOIN Invoice I on IL.InvoiceId = I.InvoiceId\n" +
                " INNER JOIN Customer C on I.CustomerId = C.CustomerId\n" +
                "WHERE C.CustomerId = 20 GROUP BY G.GenreId ORDER BY COUNT(G.GenreId) DESC;";
        try {
            conn = SQLiteDBConnector.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                customerGenreList.add(new CustomerGenre(
                        rs.getString("Name"),
                        rs.getInt("MostPopular")
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
        return customerGenreList;


    }

}
