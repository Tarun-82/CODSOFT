package atmInterface;

import java.util.Scanner;

public class ATM {

    private final BankAccount account;
    private final Scanner sc;

    public ATM(BankAccount account) {
        this.account = account;
        this.sc = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("\n===== ATM MENU =====");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Account Info");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public void startATM() {

        int choice;

        do {
            showMenu();
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter deposit amount: ");
                    account.deposit(sc.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    account.withdraw(sc.nextDouble());
                    break;

                case 3:
                    System.out.printf("Current Balance: ₹%.2f%n",
                            account.getBalance());
                    break;

                case 4:
                    account.accountInfo();
                    break;

                case 5:
                    System.out.println("Thank you for using ATM.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }
}
