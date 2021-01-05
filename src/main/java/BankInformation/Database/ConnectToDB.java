package BankInformation.Database;

import java.io.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectToDB {
    static Connection con;

    public static Connection creates() throws SQLException, IOException, ClassNotFoundException {
        try{
        Properties prop = new Properties();

        prop.load(new FileInputStream("config.properties"));
        String user = prop.getProperty("datasource.username");
        String pass = prop.getProperty("datasource.password");
        String url = prop.getProperty("datasource.url");


            Driver myDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(myDriver);
            con = DriverManager.getConnection(url,user,pass);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }


}
