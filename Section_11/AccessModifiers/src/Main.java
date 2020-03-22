public class Main {

    public static void main(String[] args) {
        Account parhamsAccount = new Account("Parham");
        parhamsAccount.deposit(1000);
        parhamsAccount.withdraw(500);
        parhamsAccount.withdraw(-200);
        parhamsAccount.deposit(-20);
        //parhamsAccount.balance = 5000;
        parhamsAccount.calculateBalance();

        System.out.println("Balance on account is " + parhamsAccount.getBalance());
        //parhamsAccount.transactions.add(4500);
    }
}
