import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

public class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void handleOption(int option) {
        Scanner scanner = new Scanner(System.in);

        switch (option) {
            case 1:
                System.out.println("Your balance is: $" + account.getBalance());
                break;
            case 2:
                System.out.print("Enter amount to deposit: $");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
                System.out.println("Deposit successful. Your new balance is: $" + account.getBalance());
                break;
            case 3:
                System.out.print("Enter amount to withdraw: $");
                double withdrawAmount = scanner.nextDouble();
                if (account.withdraw(withdrawAmount)) {
                    System.out.println("Withdrawal successful. Your new balance is: $" + account.getBalance());
                } else {
                    System.out.println("Insufficient funds. Withdrawal failed.");
                }
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Initial balance of $1000
        ATM atm = new ATM(userAccount);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            atm.handleOption(choice);
        }
    }
}
