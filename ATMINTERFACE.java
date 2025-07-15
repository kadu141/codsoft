import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance >= 0)
            this.balance = initialBalance;
        else
            this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }
}
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            showMenu();
            System.out.print("Choose an option (1-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> performWithdrawal();
                case 2 -> performDeposit();
                case 3 -> checkBalance();
                case 4 -> System.out.println("Thank you for using the ATM. Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);
    }

    private void showMenu() {
        System.out.println("\n===== ATM INTERFACE =====");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    private void performWithdrawal() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. New Balance: ₹" + account.getBalance());
        } else {
            System.out.println("Withdrawal failed. Check amount or balance.");
        }
    }

    private void performDeposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();

        if (account.deposit(amount)) {
            System.out.println("Deposit successful. New Balance: ₹" + account.getBalance());
        } else {
            System.out.println("Deposit failed. Amount should be greater than 0.");
        }
    }

    private void checkBalance() {
        System.out.println("Your current balance is: ₹" + account.getBalance());
    }
}


public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0);  // Starting with ₹1000
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
