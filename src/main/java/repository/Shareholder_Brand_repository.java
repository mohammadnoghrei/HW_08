package repository;

import model.Brand;
import model.Shareholder_Brand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Shareholder_Brand_repository {
    Connection connection;

    public Shareholder_Brand_repository(Connection connection) {
        this.connection = connection;
    }


    public int register(Shareholder_Brand shareholderBrand) throws SQLException {

        String addUser = "INSERT INTO shareholder_brand(shareholderId, brandId ) VALUES ( ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(addUser);

        preparedStatement.setInt(1, shareholderBrand.getShareholder_id());
        preparedStatement.setInt(2, shareholderBrand.getBrand_id());
        int result = preparedStatement.executeUpdate();
        return result;
    }

    public int delete_brand(int id) throws SQLException {
        String deleteUser = "DELETE FROM shareholder_brand WHERE brandId = ?;  ";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteUser);
        preparedStatement.setInt(1, id);
        int result = preparedStatement.executeUpdate();
        return result;
    }
    public int delete_shareholder(int id) throws SQLException {
        String deleteUser = "DELETE FROM shareholder_brand WHERE shareholderId = ?;  ";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteUser);
        preparedStatement.setInt(1, id);
        int result = preparedStatement.executeUpdate();
        return result;

    }

}
