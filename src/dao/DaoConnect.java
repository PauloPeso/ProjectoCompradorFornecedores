package dao;
import java.sql.*;

public class DaoConnect {
    public static Connection getConnection() {
        java.sql.Connection connection = null;
        String DRIVER = "com.mysql.cj.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:3306/compradorFornecedores";
        final String USER = "root";
        final String PASSWORD = "Admin";


        try {
            if (connection == null || connection.isClosed()) {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    


    
    
    

    
}
