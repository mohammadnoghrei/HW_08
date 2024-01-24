package repository;

import model.Product;
import model.Shareholder;

import java.sql.*;

public class Productrepository {
    Connection connection;

    public Productrepository(Connection connection) {
        this.connection = connection;
    }
    public int register(Product product) throws SQLException {

        String addUser = "INSERT INTO product(productName,createDate,categoryId, brandId) VALUES (?, ?, ?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(addUser);

        preparedStatement.setString(1, product.getProduct_name());
        preparedStatement.setDate(2, product.getCrate_date());
        preparedStatement.setInt(3, product.getCategory_id());
        preparedStatement.setInt(4, product.getBrand_id());
        int result = preparedStatement.executeUpdate();
        return result;
    }
    public int delete(int id) throws SQLException {
        String deleteUser = "DELETE FROM  product WHERE productId = ?;  ";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteUser);
        preparedStatement.setInt(1, id);
        int result = preparedStatement.executeUpdate();
        return result;

    }
    public void productlist() throws SQLException {
        String sql="select * from product order by productId";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String categoryid= resultSet.getString(3);
            String branid =resultSet.getString(4);
            System.out.println("SHAREHOLDER:  id:"+id+"  name:"+name+"  categoryid:"+categoryid+"  brandid:"+branid);

        }
    }

    public int edit_product_name(int id ,String name) throws SQLException {
        String edit = "UPDATE product set productName=? WHERE productId= ?";
        PreparedStatement preparedStatement = connection.prepareStatement(edit);
        preparedStatement.setString(1,name);
        preparedStatement.setInt(2,id);
        return preparedStatement.executeUpdate();
    }

    public int edit_createDate(int id , Date date) throws SQLException {
        String edit = "UPDATE product set createDate=? WHERE productId= ?";
        PreparedStatement preparedStatement = connection.prepareStatement(edit);
        preparedStatement.setDate(1,date);
        preparedStatement.setInt(2,id);
        return preparedStatement.executeUpdate();
    }
    public int edit_categoryId(int id ,int categoryid) throws SQLException {
        String edit = "UPDATE product set categoryId=? WHERE productId= ?";
        PreparedStatement preparedStatement = connection.prepareStatement(edit);
        preparedStatement.setInt(1,categoryid);
        preparedStatement.setInt(2,id);
        return preparedStatement.executeUpdate();
    }
    public int edit_brandId(int id ,int brandid) throws SQLException {
        String edit = "UPDATE product set brandId=? WHERE productId= ?";
        PreparedStatement preparedStatement = connection.prepareStatement(edit);
        preparedStatement.setInt(1,brandid);
        preparedStatement.setInt(2,id);
        return preparedStatement.executeUpdate();
    }
}
