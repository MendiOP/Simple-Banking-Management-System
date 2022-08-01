package com.company;
import java.util.Scanner;

class FixedDeposit extends Account {

    private double interestRate = 0.15 ;

    public FixedDeposit() {

        super();
    }

    public FixedDeposit(int accountNumber) {

        super(accountNumber);
        System.out.println("A Fixed Deposit account is created");
    }


    public double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double calcInterest() {
        return (balance * interestRate);
    }


    public void applyInterest() {
        double interest = calcInterest();
        System.out.printf("Interest amount %.2f added to balance%n", interest);
        deposit(interest);
    }

    public void deposit(double amount) {

        boolean first = false;

        if( (balance+amount) >= 100000 ) {

            if(Main.clicked) balance-=500;

            balance += amount;
            System.out.printf("Amount %.2f deposited in account number %d%n", amount, getAccountNumber());

            System.out.printf("Current Balance for account number %d is: %.2f\n",getAccountNumber(), balance);

            first = true;
        }
        else {
            System.out.println("Less than 100000 amount cannot be deposited First time");
            first = true;
        }

        if(amount > 50000 && balance != 0 && first==false){
            balance += amount;
            System.out.printf("Amount %.2f deposited in account number %d%n", amount, getAccountNumber());

            System.out.printf("Current Balance for account number %d is: %.2f%n",getAccountNumber(), balance);
        }
        else{
            if(first==false)
            System.out.println("Less than 50000 amount cannot be deposited.");
        }
    }

    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {

            if(Main.clicked == false){
                System.out.println("You have not completed maturity period.");
            }
            else if((amount) <= balance && Main.clicked == true) {

                System.out.printf("Amount of %.2f withdrawn from Account no %d%n", amount,getAccountNumber());
                balance -= amount;
                System.out.printf("Current Balance of this account no %d is: %.2f%n",getAccountNumber(), balance);
            }

            else {
                System.out.println("Sorry !! Not Enough Balance.");
            }
        } else {
            System.out.println("Negative amount cannot be withdrawn!");
        }
    }

    public double queryDeposit() {
        return this.balance;
    }
}
