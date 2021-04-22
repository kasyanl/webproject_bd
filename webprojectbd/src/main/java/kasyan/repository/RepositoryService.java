package kasyan.repository;

import kasyan.bean.Person;
import kasyan.bean.Product;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class RepositoryService {

    private static final String DRIVER="com.mysql.cj.jdbc.Driver";
    private static final String URL="jdbc:mysql://localhost:3306/product?serverTimezone=Europe/Minsk&useSSL=false";
    private static final String LOGIN="kasyanl";
    private static final String PASSWORD="kasyan123";

    //запрос на вывод Product данных из БД (формирование List)
    public List<Product> findProductFromBD(String sqlSelect) {
        List<Product> productList = new ArrayList<>();
        Connection conn = null;
        Statement statement = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(sqlSelect);

            //формирование List Product из БД
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

    //запрос на изменение (удаление, добавлене, обновление) Product в БД
    public void selectBD(String sqlSelect) {

        Connection conn = null;
        Statement statement = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = conn.createStatement();

            int rs = statement.executeUpdate(sqlSelect);
            log.info("Product is {}", rs);

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

    //запрос на вывод Product данных из корзины (формирование List)
    public List<Product> findDeleteProductFromBD(String sqlSelect) {
        List<Product> productListDel = new ArrayList<>();
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
                String data = rs.getString("data");

                productListDel.add(new Product(id, category, name, price, discount, actualPrice, data));
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
        return productListDel;
    }

    //запрос на получение Person данных из БД (формирование List)
    public List<Person> findPersonFromBD(String sqlSelect) {
        List<Person> personList = new ArrayList<>();
        Connection conn = null;
        Statement statement = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(sqlSelect);

            while (rs.next()) {

                int id = rs.getInt("id");
                String login = rs.getString("login");
                String password = rs.getString("password");

                personList.add(new Person(id, login, password));
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
        return personList;
    }
}