package BankInformation.Transactions;

import BankInformation.AccountInformation.Account;
import BankInformation.Main.BankMode;

import java.io.IOException;
import java.sql.SQLException;

public class Withdrawal extends Thread{

    Transfer tf ;
    Account account;
    int amount;

    Withdrawal(Transfer tf, Account account, int amount){
        this.tf = tf;
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {

        tf.withdraw( amount, account);



    }
}
