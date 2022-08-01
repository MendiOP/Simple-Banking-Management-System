package com.company;

import java.util.Scanner;

public class SavingsAccount extends Account {

    private double interestRate = 0.1 ;


    public SavingsAccount() {

        super();
    }

    public SavingsAccount(int accountNumber) {

        super(accountNumber);
        System.out.println("A Savings account is created");
    }

    public double getInterestRate() {

        return this.interestRate;
    }

    public void setInterestRate(double interestRate) {

        this.interestRate = interestRate;
    }

    public double calInterest() {

        return (balance * interestRate);
    }

    public void applyInterest() {
        double interest = calInterest();
        System.out.printf("Interest amount %.2f added to balance%n", interest);

        deposit(interest);
    }

    public void deposit(double amount) {

        if (amount > 0) {

            if(Main.clicked) balance-=500;

            balance += amount;
            System.out.printf("Amount %.2f deposited in account number %d%n", amount, getAccountNumber());

            System.out.printf("Current Balance for account number %d is: %.2f%n",getAccountNumber(), balance);

        } else {
            System.out.println("A negative amount cannot be deposited");
        }
    }

    public void withdraw(double amount) {

        if (amount > 0 && amount <= balance) {

            if ((balance-amount)>=1000) {
                System.out.printf("Amount of %.2f withdrawn from Account no %d%n", amount,getAccountNumber());
                balance -= amount;
                System.out.printf("Current Balance of account no %d is: %.2f%n",getAccountNumber(), balance);
            }
            else {
                System.out.println("Sorry !! Not Enough Balance.");
            }
        } else {
            System.out.println("Negative amount cannot be withdrawn!");
        }
    }

    public double queryDeposit(){
        return this.balance;
    }
}