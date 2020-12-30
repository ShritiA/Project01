package BankInformation.Main;

import BankInformation.AccountInformation.Account;

import java.io.IOException;
import java.sql.SQLException;

public interface ParentClass {
    public abstract int withdraw(int a, Account b);

    public abstract int deposit(int a, Account b);

    public abstract void entry() throws IOException, SQLException;
}
