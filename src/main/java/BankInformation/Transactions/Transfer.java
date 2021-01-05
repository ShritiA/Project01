package BankInformation.Transactions;

import BankInformation.AccountInformation.Account;
import BankInformation.Main.Bank;
import BankInformation.Database.Query;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public abstract class Transfer implements Bank {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public void menu(Account acc) throws IOException, SQLException, InterruptedException {

        boolean k = true;


        while (k) {


            System.out.println("Choose the operation you want to perform");
            System.out.println("1. Display Balance ");
            System.out.println("2. Add Money ");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit ");

            int n = Integer.parseInt(br.readLine());

            if (n == 1) {

                System.out.println("Your current balance is : " + acc.getAccount_balance());

            } else if (n == 2) {
                System.out.println("Enter the amount you want to deposit : ");
                int amt = Integer.parseInt(br.readLine());
                AddMoney addMoney = new AddMoney(this,acc,amt);
                addMoney.start();



            } else if (n == 3) {
                System.out.println("Enter the amount you want to withdraw : ");
                int amt = Integer.parseInt(br.readLine());
                Withdrawal withdrawal = new Withdrawal(this,acc,amt);
                withdrawal.start();

                System.out.println("Your current balance is : " + acc.getAccount_balance());

            } else if (n == 4) {
                k = false;

            } else {

            }
        }


    }


    synchronized public void deposit(int amount, Account b1) {
        int new_amount = b1.getAccount_balance() + amount;
        System.out.println("Amount added is " + amount);
        b1.setAccount_balance(new_amount);

        int update = Query.update_bal( b1);
        System.out.println("Your current balance is : " + update);


    }

    synchronized public void withdraw(int amount, Account b1) {
        if (b1.getAccount_balance() >= amount) {
            int new_amount = b1.getAccount_balance() - amount;
            b1.setAccount_balance(new_amount);
            int update = Query.update_bal(b1);
            System.out.println("Your current balance is : " + update);

        } else {
            System.out.println("Not enough balance");
        }





    }
}


