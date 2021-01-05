package BankInformation.Transactions;

import BankInformation.AccountInformation.Account;
import BankInformation.Database.ConnectToDB;
import BankInformation.Database.Query;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;

public class NetBanking extends Transfer {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void entry() throws IOException, SQLException, InterruptedException {

       try {
           System.out.println("Enter user id");

           int user = Integer.parseInt(br.readLine());


           int length = String.valueOf(user).length();
           if (length <= 1) {

           }
           System.out.println("Enter password ");
           String pw = br.readLine();
           boolean k = this.validate(user, pw);
           if (k == true) {

               Account acc = this.fetch_account_details(user, pw);
               this.menu(acc);

           }
       } catch ( NumberFormatException e){
           System.out.println("Wrong User id , try again ");
       } catch (InputMismatchException e){
           System.out.println("Wrong Password ");

       }



    }

    public static boolean validate(int user_name, String pw) throws SQLException {

        boolean flag = false;

        try {

            Connection con = ConnectToDB.creates();
            String q = String.format("Select user_id,web_pw from netbanking where user_id=%d and web_pw='%s';",user_name,pw);

            Statement stmt = con.createStatement();

            ResultSet set = stmt.executeQuery(q);

            while (set.next()) {

                int user_id = set.getInt("user_id");
                String password = set.getString("web_pw");


                if (user_id == user_name && password.equals(pw)) {
                    flag = true;
                    System.out.println("Welcome");
                }


                if (!flag) {
                    System.out.println("Incorrect password or user id ");
                }


            }

            set.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }





    public static Account fetch_account_details(int userid, String pass) {
        try {

            Connection con = ConnectToDB.creates();
            String q = String.format("Select * from netbanking as n inner join atm as a on n.account_id=a.account_id where user_id=%d and web_pw='%s'",userid,pass);

            Statement stmt = con.createStatement();

            ResultSet set = stmt.executeQuery(q);


            while(set.next()) {


                int user_id = set.getInt("user_id");
                String password = set.getString("web_pw");
                int bal = set.getInt("balance");
                int account_id = set.getInt("account_id");
                int pin = set.getInt("pin");

                Account acc = new Account(user_id, password, bal, account_id, pin);
                return acc;
            }
        }
        catch( Exception e){
            e.printStackTrace();

        }
        return null;



    }


}
