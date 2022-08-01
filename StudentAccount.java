package com.company;
import java.util.Scanner;

class StudentAccount extends Account {

    private double interestRate = 0.05 ;

    public StudentAccount() {

        super();
    }

    public StudentAccount(int accountNumber) {

        super(accountNumber);
        System.out.println("A student account is created");
    }


    public double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double calcInterest() {
        return balance * interestRate;
    }

    //public boolean getsClicked(){
        //return true;
    //}

    public void applyInterest() {
        double interest = calcInterest();
        System.out.printf("Interest amount %.2f added to balance%n", interest);
        deposit(interest);
    }

    public void deposit(double amount) {

        if( amount > 0) {
            balance += amount;
            System.out.printf("Amount %.2f deposited in account number %d%n", amount, getAccountNumber());

            System.out.printf("Current Balance for account number %d is: %.2f%n",getAccountNumber(), balance);

        } else {
            System.out.println("A negative amount cannot be deposited");
        }
    }

    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {

            if(amount>=10000){
                System.out.println("Sorry !! You are not allowed to withdraw 10000 or more at a time.");
            }
            else if((amount) <= balance) {

                System.out.printf("Amount of %.2f withdrawn from Account no %d%n", amount,getAccountNumber());
                balance -= amount;
                System.out.printf("Current Balance of account no %d is: %.2f%n", getAccountNumber(),balance);
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
