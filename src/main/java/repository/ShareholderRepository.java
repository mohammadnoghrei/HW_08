package repository;

import model.Shareholder;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShareholderRepository {
    private final java.sql.Connection connection;

    public ShareholderRepository(Connection connection) {
        this.connection = connection;
    }
    public int register(Shareholder shareholder) throws SQLException {

        String addUser = "INSERT INTO shareholders(shareholderName, phonenumber,nationalcode) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(addUser);

        preparedStatement.setString(1, shareholder.getShareholder_name());
        preparedStatement.setString(2, shareholder.getPhonenumber());
        preparedStatement.setString(3, shareholder.getNationalcode());
        int result = preparedStatement.executeUpdate();
        return result;
    }
    public Shareholder find(String nationalcode) throws SQLException {

        String findUser = "SELECT * FROM shareholders WHERE nationalcode = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(findUser);
        preparedStatement.setString(1, nationalcode);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            int id = resultSet.getInt("shareholderId");
            String name= resultSet.getString("shareholderName");
            String phoneNumber = resultSet.getString("phoneNumber");
            String fetchnationalcode = resultSet.getString("nationalCode");

            Shareholder shareholder=new Shareholder(id,name,phoneNumber,fetchnationalcode);
            return shareholder;
        }
        else
            return null;
    }
    public int edit_shareholder_name(int id ,String name) throws SQLException {
        String editShareholderName = "UPDATE shareholders set shareholderName=? WHERE shareholderId= ?";
        PreparedStatement preparedStatement = connection.prepareStatement(editShareholderName);
        preparedStatement.setString(1,name);
        preparedStatement.setInt(2,id);
        return preparedStatement.executeUpdate();

    }
    public int edit_shareholder_phonenumber(int id ,String phonenumber) throws SQLException {
        String editShareholder = "UPDATE shareholders set phoneNumber=? WHERE shareholderId= ?";
        PreparedStatement preparedStatement = connection.prepareStatement(editShareholder);
        preparedStatement.setString(1,phonenumber);
        preparedStatement.setInt(2,id);
        return preparedStatement.executeUpdate();

    }
    public int edit_shareholder_nationalCode(int id ,String nationalCode) throws SQLException {
        String editShareholder = "UPDATE shareholders set nationalCode=? WHERE shareholderId= ?";
        PreparedStatement preparedStatement = connection.prepareStatement(editShareholder);
        preparedStatement.setString(1,nationalCode);
        preparedStatement.setInt(2,id);
        return preparedStatement.executeUpdate();

    }

    public int delete(int id) throws SQLException {
        String delete = "DELETE FROM shareholder_brand WHERE shareholderId =?;  ";
        PreparedStatement preparedStatement2 = connection.prepareStatement(delete);
        preparedStatement2.setInt(1, id);
        int result2 = preparedStatement2.executeUpdate();

        String deleteUser = "DELETE FROM shareholders WHERE shareholderId = ?;  ";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteUser);
        preparedStatement.setInt(1, id);
        int result = preparedStatement.executeUpdate();
        return result;

    }
    public void shareholderlist() throws SQLException {
        String sql="select * from shareholders order by shareholderId";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String phonenumber = resultSet.getString(3);
            String nationalcode =resultSet.getString(4);
            System.out.println("SHAREHOLDER:  id:"+id+"  name:"+name+"  phonenumber:"+phonenumber+"  nationalcode:"+nationalcode);

        }
    }
}
