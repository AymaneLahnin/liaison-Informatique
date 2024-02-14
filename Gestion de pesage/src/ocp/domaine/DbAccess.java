package ocp.domaine;
//modele
import javax.swing.*;
import java.sql.*;

public class DbAccess {
    private Connection connection;
    private Statement statement;

    public DbAccess(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql:///observation","root","hahaAymane2019....");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query){
        try {
            statement= connection.createStatement();
            return statement.executeQuery(query);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void executeUpdate(String query){
        try {
            statement= connection.createStatement();
            statement.executeUpdate(query);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int linesCount(ResultSet rs) throws SQLException {
        int rowCount=0;
        while (rs.next()){
            rowCount++;
        }
        return rowCount;
    }


}