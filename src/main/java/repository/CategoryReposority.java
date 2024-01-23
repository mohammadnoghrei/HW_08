package repository;

import model.Category;
import model.Shareholder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryReposority {
    Connection connection;

    public CategoryReposority(Connection connection) {
        this.connection = connection;
    }
    public int register(Category category) throws SQLException {

        String addUser = "INSERT INTO category(categoryName, description) VALUES ( ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(addUser);

        preparedStatement.setString(1, category.getCategory_name());
        preparedStatement.setString(2, category.getDescription());
        int result = preparedStatement.executeUpdate();
        return result;
    }
    public int edit_category_name(int id ,String name) throws SQLException {
        String editcategoryName = "UPDATE category set categoryName=? WHERE categoryId= ?";
        PreparedStatement preparedStatement = connection.prepareStatement(editcategoryName);
        preparedStatement.setString(1,name);
        preparedStatement.setInt(2,id);
        return preparedStatement.executeUpdate();

    }
    public int edit_category_description(int id ,String description) throws SQLException {
        String editcategorydescription = "UPDATE category set description=? WHERE categoryId= ?";
        PreparedStatement preparedStatement = connection.prepareStatement(editcategorydescription);
        preparedStatement.setString(1, description);
        preparedStatement.setInt(2, id);
        return preparedStatement.executeUpdate();
    }
    public int delete(int id) throws SQLException {
        String deleteUser = "DELETE FROM category WHERE categoryId = ?;  ";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteUser);
        preparedStatement.setInt(1, id);
        int result = preparedStatement.executeUpdate();
        return result;

    }
    public void categorylist() throws SQLException {
        String sql="select * from category order by categoryId";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String description = resultSet.getString(3);
            System.out.println("category:  id:"+id+"  name:"+name+"  description:"+description);

        }
    }
}
