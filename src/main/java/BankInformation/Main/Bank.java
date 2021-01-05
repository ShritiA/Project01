package BankInformation.Main;

import BankInformation.AccountInformation.Account;
import BankInformation.Transactions.exceptionLibrary;

import java.io.IOException;
import java.sql.SQLException;

public interface Bank {
    public abstract void withdraw(int a, Account b);

    public abstract void deposit(int a, Account b);

    public abstract void entry() throws IOException, SQLException, InterruptedException, exceptionLibrary;
}
