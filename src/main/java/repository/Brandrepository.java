package repository;

import model.Brand;
import model.Shareholder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Brandrepository {
    Connection connection;

    public Brandrepository(Connection connection) {this.connection = connection;}

    public int register(Brand brand) throws SQLException {

        String addUser = "INSERT INTO brand(brandName, website,description ) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(addUser);

        preparedStatement.setString(1, brand.getBrand_name());
        preparedStatement.setString(2, brand.getWebsite());
        preparedStatement.setString(3, brand.getWebsite());
        int result = preparedStatement.executeUpdate();
        return result;
    }
    public int edit_brand_name(int id ,String name) throws SQLException {
        String editbrand = "UPDATE brand set brandName=? WHERE brandId= ?";
        PreparedStatement preparedStatement = connection.prepareStatement(editbrand);
        preparedStatement.setString(1,name);
        preparedStatement.setInt(2,id);
        return preparedStatement.executeUpdate();
    }

    public int edit_brand_wbsite(int id ,String website) throws SQLException {
        String editbrand = "UPDATE brand set website=? WHERE brandId= ?";
        PreparedStatement preparedStatement = connection.prepareStatement(editbrand);
        preparedStatement.setString(1,website);
        preparedStatement.setInt(2,id);
        return preparedStatement.executeUpdate();
    }

    public int edit_brand_description(int id ,String description) throws SQLException {
        String editbrand = "UPDATE brand set description=? WHERE brandId= ?";
        PreparedStatement preparedStatement = connection.prepareStatement(editbrand);
        preparedStatement.setString(1,description);
        preparedStatement.setInt(2,id);
        return preparedStatement.executeUpdate();
    }

    public int delete(int id) throws SQLException {
        String delete2 = "DELETE FROM product WHERE brandId =?;  ";
        PreparedStatement preparedStatement3 = connection.prepareStatement(delete2);
        preparedStatement3.setInt(1, id);
        int result3 = preparedStatement3.executeUpdate();

        String delete = "DELETE FROM shareholder_brand WHERE brandId =?;  ";
        PreparedStatement preparedStatement2 = connection.prepareStatement(delete);
        preparedStatement2.setInt(1, id);
        int result2 = preparedStatement2.executeUpdate();


        String deleteUser = "DELETE FROM brand WHERE brandId = ?;  ";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteUser);
        preparedStatement.setInt(1, id);
        int result = preparedStatement.executeUpdate();
        return result;

    }


    public void brandlist() throws SQLException {
        String sql="select * from brand order by brandId";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String website = resultSet.getString(3);
            String description =resultSet.getString(4);
            System.out.println("BRAND: id:"+id+"  name:"+name+"  website:"+website+"  description:"+description);

        }
    }
}
