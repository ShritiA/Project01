package BankInformation.Transactions;

import BankInformation.AccountInformation.Account;

public class AddMoney extends Thread{

    Transfer tf ;
    Account account;
    int amount;
    AddMoney(Transfer tf, Account account, int amount){
        this.tf = tf;
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {

        tf.deposit( amount, account);



    }
}
