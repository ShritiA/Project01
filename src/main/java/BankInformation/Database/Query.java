package BankInformation.Database;

import BankInformation.AccountInformation.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Query {


    public static int display_balance(Account b2) throws SQLException {


        try {

            Connection con = BankInformation.Database.ConnectToDB.creates();
            String q = "Select balance from netbanking where user_id=?;";


            PreparedStatement st = con.prepareStatement(q);
            st.setInt(1, b2.getUser_id());

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                b2.setAccount_balance(rs.getInt(1));

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return b2.getAccount_balance();

    }


    public static int update_bal( Account b2) {

        try {

            Connection con = BankInformation.Database.ConnectToDB.creates();

            int acc = b2.getAccount_id();
            String q = (String.format("UPDATE netbanking SET balance=%d where account_id=%d ;", b2.getAccount_balance(),acc) );


            PreparedStatement st = con.prepareStatement(q);

            st.executeUpdate(q);

            st.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        b2.getAccount_balance();


        return b2.getAccount_balance();

    }


}



