package BankInformation.Main;

import BankInformation.Transactions.TransactionsFactory;
import BankInformation.Transactions.Transfer;
import BankInformation.Transactions.exceptionLibrary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.InputMismatchException;

public class BankMode {

    public void menu() throws IOException {

        TransactionsFactory tf = new TransactionsFactory();

        Transfer tr = tf.getInstance(0);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean flag = true;


        while (flag) {


            System.out.println("Choose the mode of transactions : ");
            System.out.println("Press 1 for NetBanking");
            System.out.println("Press 2 for ATM");
            System.out.println("Press 3 for Cheque");
            System.out.println("Press 4 to Exit");

            try {
                int c = Integer.parseInt(br.readLine());

                if (c == 4) {

                    System.exit(0);

                } else if(c > 4) {
                    System.out.println("This is not a correct option, Choose again");
                    continue;
                }



                tr = tf.getInstance(c);
            }

            catch(NumberFormatException e){
                System.out.println("Please choose a number from 1-4");
                continue;
            }
            try {
                tr.entry();
            } catch (IOException | SQLException | InterruptedException e) {
                e.printStackTrace();
            } catch (BankInformation.Transactions.exceptionLibrary exceptionLibrary) {
                exceptionLibrary.printStackTrace();
            }
        }
    }
}

