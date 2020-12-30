package BankInformation.Database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB {
    static Connection con;

    public static Connection creates() throws SQLException {
        try {
            Driver myDriver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(myDriver);
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankinfo","root","1234");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}
