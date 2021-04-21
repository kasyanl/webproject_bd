package kasyan.util;

import kasyan.bean.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLConfiguration {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/product?serverTimezone=Europe/Minsk&useSSL=false";
    private static final String LOGIN = "kasyanl";
    private static final String PASSWORD = "kasyan123";


    public List<Product> findProductFromBD(String sqlSelect) {
        List<Product> productList = new ArrayList<>();
        Connection conn = null;
        Statement statement = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(sqlSelect);

            while (rs.next()) {

                int id = rs.getInt("id");
                String category = rs.getString("category");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                double discount = rs.getDouble("discount");
                double actualPrice = rs.getDouble("actualPrice");

                productList.add(new Product(id, category, name, price, discount, actualPrice));
            }
            rs.close();
            statement.close();
            conn.close();
        } catch (Exception se) {
            se.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException ignored) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return productList;
    }

    public void selectBD(String sqlSelect) {

        Connection conn = null;
        Statement statement = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(sqlSelect);

            rs.close();
            statement.close();
            conn.close();
        } catch (Exception se) {
            se.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException ignored) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public Product findByIdFromBD(String sqlSelect) {

        Product product = new Product();
        Connection conn = null;
        Statement statement = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sqlSelect);

            while (rs.next()) {
                int id = rs.getInt("id");
                String category = rs.getString("category");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                double discount = rs.getDouble("discount");
                double actualPrice = rs.getDouble("actualPrice");

                product = new Product(id, category, name, price, discount, actualPrice);
            }
            rs.close();
            statement.close();
            conn.close();
        } catch (Exception se) {
            se.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException ignored) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return product;
    }

}
