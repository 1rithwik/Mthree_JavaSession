package main.sep_18;

import java.util.Scanner;

public class BankApplication {
    String name;
    String BankName;
    String Branch;
    int depositmoney;
    int withdrawmoney;
    int balance = 0;
    static int rateofinterest = 5;
    int time_in_years;
    int totalamount = 0;
    int totalinterest = 0;

    public void accountOpen() {
        System.out.println("Account opened successfully");
    }

    public void depositMoney(int depositmoney) {
        balance = balance + depositmoney;
        System.out.println("Deposited money: " + balance);
    }

    public void withdrawMoney(int withdrawmoney) {
        if (balance < withdrawmoney) {
            System.out.println("Insufficient balance");
        } else {
            balance = balance - withdrawmoney;
            System.out.println("money withdrawn successfully");
        }
    }

    public void checkBalance() {
        System.out.println("Balance: " + balance);
    }

    public void calculateInterest(int rateofinterest, int time_in_years) {
        totalinterest = (balance * rateofinterest * time_in_years) / 100;
        System.out.println("Total interest: " + totalinterest);
    }

    public void AccountDetails() {
        System.out.println("Account details: " + name + " " + BankName + " " + Branch);
        System.out.println("Balance: " + balance);
    }

    public void closeAccount() {
        System.out.println("closed successfully");
    }

    public static void main(String[] args) {
        BankApplication per1 = new BankApplication();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name: ");
        per1.name = sc.nextLine();
        System.out.println("Enter the BankName: ");
        per1.BankName = sc.nextLine();
        System.out.println("Enter the Branch: ");
        per1.Branch = sc.nextLine();
        per1.accountOpen();
        while (true) {
            System.out.println("Choose what you want to do:");
            System.out.println("1. Deposit money");
            System.out.println("2. Withdraw money");
            System.out.println("3. Check balance");
            System.out.println("4. Calculate interest");
            System.out.println("5. Account details");
            System.out.println("6. Close account");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the amount to deposit: ");
                    int a = sc.nextInt();
                    per1.depositMoney(a);
                    break;
                case 2:
                    System.out.println("Enter the amount to withdraw: ");
                    int b = sc.nextInt();
                    per1.withdrawMoney(b);
                    break;
                case 3:
                    per1.checkBalance();
                    break;
                case 4:
                    System.out.println("Enter the time in years: ");
                    int c = sc.nextInt();
                    per1.calculateInterest(rateofinterest, c);
                    break;
                case 5:
                    per1.AccountDetails();
                    break;
                case 6:
                    per1.closeAccount();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
