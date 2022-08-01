package com.company;

import java.util.Scanner;

public class Main {

    static public boolean clicked = false;
    
    public static void main(String [] args) {

        Scanner scan = new Scanner(System.in);


        Account accounts [] = new Account[10];
        int numAccounts = 0;

        for(int choice = 0 ; choice<=5 ; ) {
            choice = bank_menu(scan);
            System.out.println();

            if(choice == 1) {
                accounts[numAccounts++] = createAccount(scan);
            } else if(choice == 2) {
                doDeposit(accounts, numAccounts, scan);
            } else if(choice == 3) {
                doWithdraw(accounts, numAccounts, scan);
            } else if(choice == 4) {
                applyInterest(accounts, numAccounts, scan);
            } else if(choice == 5){
                qDeposit(accounts, numAccounts, scan);
            }

            else {
                System.out.println("Thanks For using our Bank !");
            }
            System.out.println();
        }
    }

    public static int accountType(Scanner scan) {
        System.out.println("Select Account Type");
        System.out.println("1. Student Account");
        System.out.println("2. Savings Account");
        System.out.println("3. Fixed Deposit Account");

        System.out.print("Enter choice: ");
        int choice = scan.nextInt();

        return choice;
    }

    public static int searchAccount(Account accounts [], int count, int holderName) {

        for(int i=0; i<count; i++) {
            if(accounts[i].getAccountNumber() == holderName) {
                return i;
            }
        }

        return -1;
    }

    public static void doDeposit(Account accounts [], int count, Scanner scan) {

        System.out.print("\nPlease enter account number: ");
        int accountNumber= scan.nextInt();

        int index = searchAccount(accounts, count, accountNumber);

        if(index >= 0) {

            System.out.print("Please enter Deposit Amount: ");
            double amount = scan.nextDouble();

            accounts[index].deposit(amount);
        } else {
            System.out.println("No account exist with : " + accountNumber);
        }
    }

    public static void doWithdraw(Account accounts [], int count, Scanner scan) {

        System.out.print("\nPlease enter account number: ");
        int accountNumber= scan.nextInt();

        int index = searchAccount(accounts, count, accountNumber);

        if(index >= 0) {
            System.out.print("Please enter Withdraw Amount: ");
            double amount = scan.nextDouble();
            accounts[index].withdraw(amount);
        } else {
            System.out.println("No account exist with the account no : " + accountNumber);
        }
    }

    public static boolean applyInterest(Account accounts [], int count, Scanner scan) {

        //System.out.println("Please enter account Holder Name: ");
        //int accountNumber= scan.nextInt();

        //int index = searchAccount(accounts, count, holderName);
        clicked = true;

        for (int i = 0; i < count; i++) {
            if (accounts[i] instanceof SavingsAccount) {
                ((SavingsAccount) accounts[i]).applyInterest();
            } else if (accounts[i] instanceof StudentAccount) {
                ((StudentAccount) accounts[i]).applyInterest();
            } else if (accounts[i] instanceof FixedDeposit) {
                ((FixedDeposit) accounts[i]).applyInterest();
            } else {
                System.out.println("No account exist with the given account number");
            }
        }
        return clicked;
    }


    public static void qDeposit(Account accounts [], int count, Scanner scan){

        System.out.print("\nPlease enter account number : ");
        int accountNumber= scan.nextInt();

        int index = searchAccount(accounts, count, accountNumber);

        if(index >= 0) {

            if(accounts[index] instanceof SavingsAccount) {

              double currentAmount = ((SavingsAccount)accounts[index]).queryDeposit();
                System.out.printf("Current amount of this account no %d is %.2f",accountNumber, currentAmount);
            }
            else  if(accounts[index] instanceof StudentAccount){

                double currentAmount = ((StudentAccount)accounts[index]).queryDeposit();
                System.out.printf("Current amount of this account no %d is %.2f",accountNumber, currentAmount);
            }
            else  if(accounts[index] instanceof FixedDeposit){

                double currentAmount = ((FixedDeposit)accounts[index]).queryDeposit();
                System.out.printf("Current amount of this account no %d is %.2f",accountNumber, currentAmount);
            }
        } else {
            System.out.println("No account exist with the account no: " + accountNumber);
        }


    }
    
    public static Account createAccount(Scanner scan) {

        Account account = null;
        int choice = accountType(scan);

        System.out.print("Enter Account number: ");
        int accountNumber= scan.nextInt();

        if(choice == 1)  {
            account = new StudentAccount(accountNumber);
        } else if(choice == 2){
            account = new SavingsAccount(accountNumber);
        }else {
            account = new FixedDeposit(accountNumber);
        }
        return account;
    }

    public static int bank_menu(Scanner scan) {
        System.out.println("Bank Account Menu");
        System.out.println("1. Create New Account");
        System.out.println("2. Deposit Funds");
        System.out.println("3. Withdraw Funds");
        System.out.println("4. INC (1 year passsed)");
        System.out.println("5. Query Deposit");
        System.out.println("6. Quit");

        int choice;

        do {
            System.out.println("Enter choice: ");
            choice = scan.nextInt();
        } while(choice < 1 || choice > 6);

        return choice;
    }
}