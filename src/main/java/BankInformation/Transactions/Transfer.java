package BankInformation.Transactions;

import BankInformation.AccountInformation.Account;
import BankInformation.Main.ParentClass;
import BankInformation.Database.Query;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public abstract class Transfer implements ParentClass {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void menu(Account acc) throws IOException, SQLException {

        boolean k = true;


       while(k){

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
                int new_amount = this.deposit(amt, acc);


            } else if (n == 3) {
                System.out.println("Enter the amount you want to withdraw : ");
                int amt = Integer.parseInt(br.readLine());
                int new_amount = this.withdraw(amt, acc);
                int update = Query.update_bal(new_amount, acc);
                System.out.println("Your current balance is : " + update);

            } else if(n==4){
                 k = false;

            } else{

            }
        }



    }
}

