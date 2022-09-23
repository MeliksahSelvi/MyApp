package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {

    private static Connection connection=null;

    private static Connection connectDB(){
        if (connection != null) return connection;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }

        try {
            connection= DriverManager.getConnection(Config.DB_Url,Config.DB_User,Config.DB_Password);
        } catch (SQLException e) {
            e.getMessage();
        }
        return connection;
    }

    public static Connection getInstance(){
        return connectDB();
    }
}
