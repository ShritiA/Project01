package BankInformation.Main;

import BankInformation.Transactions.Transfer;
import BankInformation.Transactions.TransactionsFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class FactoryMain {
    public static void main(String[] args) throws SQLException, IOException {

        TransactionsFactory tf = new TransactionsFactory();

        Transfer tr = tf.getInstance(0);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean flag = true;


        while (flag) {


            System.out.println("Choose the mode of transactions : ");
            System.out.println("1. NetBanking");
            System.out.println("2. ATM");
            System.out.println("3. Cheque");
            System.out.println("4. Exit");

            int c = Integer.parseInt(br.readLine());

            if (c == 4) {

                System.exit(0);

            }

            tr = tf.getInstance(c);
            tr.entry();

        }
    }
}



