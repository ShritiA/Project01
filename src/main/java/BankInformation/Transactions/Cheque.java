package BankInformation.Transactions;

import BankInformation.AccountInformation.Account;
import BankInformation.Database.ConnectToDB;
import BankInformation.Database.Query;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Cheque extends Transfer {

    public void entry() throws IOException, SQLException, InterruptedException {

      try {
          System.out.println("Enter account id");
          int account_id = Integer.parseInt(br.readLine());
          boolean k = this.validate(account_id);
          if (k == true) {

              Account acc = this.fetch_account_details(account_id);
              this.menu(acc);

          }
      } catch(NumberFormatException e){
          System.out.println("Please enter correct account id");
      }

    }

    public static boolean validate( int account_id) throws SQLException {

        boolean flag = false;

        try {

            Connection con = ConnectToDB.creates();
            String q = String.format("Select account_id from atm where account_id=%d;", account_id);

            Statement stmt = con.createStatement();

            ResultSet set = stmt.executeQuery(q);
            System.out.println(set);

            while (set.next()) {

                int a = set.getInt(1);

                if (a== account_id) {
                    flag = true;
                    System.out.println("Welcome");
                }


                if (!flag) {
                    System.out.println("Incorrect ");
                }


            }
            set.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static Account fetch_account_details(int account_id) {
        try {

            Connection con = ConnectToDB.creates();
            String q = String.format("Select user_id, web_pw, balance, n.account_id,pin from netbanking as n inner join atm as a on n.account_id=a.account_id where n.account_id=%d",account_id);

            Statement stmt = con.createStatement();

            ResultSet set = stmt.executeQuery(q);


            while(set.next()) {


                int user_id = set.getInt("user_id");
                String password = set.getString("web_pw");
                int bal = set.getInt("balance");
                int account = set.getInt("account_id");
                int p = set.getInt("pin");

                Account acc = new Account(user_id, password, bal, account, p);
                return acc;
            }
        }
        catch( Exception e){
            e.printStackTrace();

        }
        return null;



    }


}
