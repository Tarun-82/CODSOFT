package atmInterface;

public class Main {

    public static void main(String[] args) {

        BankAccount account =
                new BankAccount(
                        "28979320397",
                        5000,
                        "Tarun Kumar"
                );

        ATM atm = new ATM(account);

        atm.startATM();
    }
}
