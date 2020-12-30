package BankInformation.AccountInformation;

public class Account {
    private int account_balance;
    private int pin;
    private int user_id;
    private String password;
    int account_id;


   public Account(int user_id, String password, int account_balance,int account_id, int pin){
       this.user_id = user_id;
       this.password = password;
       this.account_balance = account_balance ;
       this.account_id = account_id;
       this.pin = pin;

   }

   public Account(int user_id, String password){
       this.user_id = user_id;
       this.password = password;
   }

    public int getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(int account_balance) {
        this.account_balance = account_balance;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }
}







