package BankInformation.Transactions;

public class TransactionsFactory {

    public Transfer getInstance(int i){
        if (i==1) {
            return new NetBanking();
        } else if(i==2){
            return new ATM();
        } else if(i==3){
            return new Cheque();
        }
        else return null;

    }
}
