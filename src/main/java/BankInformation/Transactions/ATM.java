package BankInformation.Transactions;

import BankInformation.AccountInformation.Account;
import BankInformation.Database.ConnectToDB;
import BankInformation.Database.Query;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ATM extends Transfer {

    public void entry() throws IOException, SQLException {

        System.out.println("Enter account id");
        int account_id = Integer.parseInt(br.readLine());
        System.out.println("Enter pin ");
        int pin =Integer.parseInt(br.readLine());
        boolean k = this.validate(pin,account_id);
        if(k==true){

            Account acc = this.fetch_account_details(pin,account_id);
            this.menu(acc);

        }


    }

    public static boolean validate(int pin, int account_id) throws SQLException {

        boolean flag = false;

        try {

            Connection con = ConnectToDB.creates();
            String q = String.format("Select pin from atm where pin=%d and account_id=%d;",pin, account_id);

            Statement stmt = con.createStatement();

            ResultSet set = stmt.executeQuery(q);
            System.out.println(set);

            while (set.next()) {

                int p = set.getInt(1);

                if (p == pin) {
                    flag = true;
                    System.out.println("Welcome to the bank");
                }


                if (!flag) {
                    System.out.println("Incorrect Pin , Try Again  ");
                }


            }
            set.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
    public static Account fetch_account_details(int pin, int account_id) {
        try {

            Connection con = ConnectToDB.creates();
            String q = String.format("Select user_id, web_pw, balance, n.account_id,pin from netbanking as n inner join atm as a on n.account_id=a.account_id where pin=%d and n.account_id=%d",pin,account_id);

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



    @Override
    public int withdraw(int amount, Account b1) {
        if(b1.getAccount_balance()>=amount) {
            int new_amount = b1.getAccount_balance() - amount;
            b1.setAccount_balance(new_amount);
            int update = Query.update_bal(new_amount, b1);
            System.out.println("Your current balance is : " + update);
            return new_amount;
        } else {
            System.out.println("Not enough balance");
        }

        return b1.getAccount_balance();

    }

    @Override
    public int deposit(int amount, Account b1) {
        int new_amount = b1.getAccount_balance()+amount;
        System.out.println("Amount added is " + amount);
        b1.setAccount_balance(new_amount);

        int update = Query.update_bal(new_amount,b1);
        System.out.println("Your current balance is : " + update);


        return new_amount;

    }


}
