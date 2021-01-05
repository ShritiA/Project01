package BankInformation.Main;

import BankInformation.Transactions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class BankingApp {
    public static void main(String[] args) throws SQLException, IOException {

       BankMode bankMode = new BankMode();
       bankMode.menu();

        }

}




