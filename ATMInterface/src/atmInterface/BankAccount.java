package atmInterface;

public class BankAccount {

    private final String accountNo;
    private final String holderName;
    private double balance;

    public BankAccount(String accountNo, double balance, String holderName) {

        if(accountNo == null || accountNo.trim().isEmpty()){
            throw new IllegalArgumentException("Account Number cannot be empty");
        }

        if(holderName == null || holderName.trim().isEmpty()){
            throw new IllegalArgumentException("Holder Name cannot be empty");
        }

        if(balance < 0){
            throw new IllegalArgumentException("Balance cannot be negative");
        }

        this.accountNo = accountNo;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount!");
            return;
        }

        balance += amount;
        System.out.printf("₹%.2f deposited successfully.%n", amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance!");
            return;
        }

        balance -= amount;
        System.out.printf("₹%.2f withdrawn successfully.%n", amount);
    }

    public double getBalance() {
        return balance;
    }

    public void accountInfo() {
        System.out.println("\n===== ACCOUNT INFO =====");
        System.out.println("Account No : " + accountNo);
        System.out.println("Holder Name: " + holderName);
        System.out.printf("Balance    : ₹%.2f", balance);
    }
}