package DatabaseProgramming001.manager;

import DatabaseProgramming001.DatabaseUtilities;
import DatabaseProgramming001.entity.Product;

import java.sql.*;
import java.util.ArrayList;

public class ProductManager {


    public boolean insert( Product product) throws ClassNotFoundException, SQLException {

        Connection connection = DatabaseUtilities.getConnection();

        //sql injection'u önlemek için bu yöntemi kullan
        String sql = "insert into Product(productName, salesPrice) values (?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, product.getProductName());
        statement.setDouble(2, product.getSalesPrice());
        int affected = statement.executeUpdate();

        connection.close();
        return affected ==1 ? true: false;

    }
    public Product find(long productId) throws SQLException, ClassNotFoundException {

        Product product = null;
        Connection connection = DatabaseUtilities.getConnection();

        //sql injection'u önlemek için bu yöntemi kullan
        String sql = "select * from Product where productId=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, productId);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) { // if kullandık çünkü 1 değer dönecek

            product = new Product();
            product.setProductId(productId);
            product.setProductName(resultSet.getString("productName"));
            product.setSalesPrice(resultSet.getFloat("salesPrice"));
        }

        connection.close();

        return product;
    }
    public boolean update(Product product) throws SQLException, ClassNotFoundException {

        Connection connection = DatabaseUtilities.getConnection();

        String sql = "update Product set productName=?, salesPrice=? where productId=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, product.getProductName());
        statement.setDouble(2, product.getSalesPrice());
        statement.setLong(3, product.getProductId());

        int affected = statement.executeUpdate();
        connection.close();
        return affected == 1 ? true:false;
    }
    public boolean delete(long productId ) throws SQLException, ClassNotFoundException {

        Connection connection = DatabaseUtilities.getConnection();

        String sql = "delete from Product where productId=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, productId);

        int affected = statement.executeUpdate();
        connection.close();
        return affected == 1 ? true:false;
    }
    public ArrayList<Product> list() throws SQLException, ClassNotFoundException {

        ArrayList<Product> list = new ArrayList<>();
        Connection connection = DatabaseUtilities.getConnection();
        String sql = "select * from Product";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            Product product = new Product();
            product.setProductId( resultSet.getLong("productId") );
            product.setProductName( resultSet.getString("productName"));
            product.setSalesPrice(resultSet.getFloat("salesPrice"));
            list.add(product);
        }
        connection.close();
        return list;
    }
    public ArrayList<Product> listByProductNameLike(String productNamePattern) throws SQLException, ClassNotFoundException {

        ArrayList<Product> list = new ArrayList<>();
        Connection connection = DatabaseUtilities.getConnection();
        String sql = "select * from Product where productName like ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, productNamePattern);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            Product product = new Product();
            product.setProductId( resultSet.getLong("productId") );
            product.setProductName( resultSet.getString("productName"));
            product.setSalesPrice(resultSet.getFloat("salesPrice"));
            list.add(product);
        }
        connection.close();
        return list;
    }

    public ArrayList<Product> listByProductNameLikeAnd(String productNamePattern, double salesPrice) throws SQLException, ClassNotFoundException {

        ArrayList<Product> list = new ArrayList<>();
        Connection connection = DatabaseUtilities.getConnection();
        String sql = "select * from Product where productName like ? and salesPrice>=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, productNamePattern);
        statement.setDouble(2, salesPrice);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            Product product = new Product();
            product.setProductId( resultSet.getLong("productId") );
            product.setProductName( resultSet.getString("productName"));
            product.setSalesPrice(resultSet.getFloat("salesPrice"));
            list.add(product);
        }
        connection.close();
        return list;
    }
}
