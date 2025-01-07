# Simple Banking Management System

This is a simple banking management system implemented in Java. The system allows users to create different types of bank accounts, deposit and withdraw funds, apply interest, and query the current balance. Below is an analysis of the codebase.

## **Project Structure**

The project consists of the following Java classes:

- **Account.java**: An abstract class that serves as the base class for all account types.
- **SavingsAccount.java**: A subclass of `Account` that represents a savings account.
- **FixedDeposit.java**: A subclass of `Account` that represents a fixed deposit account.
- **StudentAccount.java**: A subclass of `Account` that represents a student account.
- **Main.java**: The main class that handles user interaction and manages the banking operations.

## **Key Features**

### **Account Types**

- **Savings Account**:
  - Interest rate: 10%
  - Minimum balance requirement: 1000
  - Interest is applied annually.
- **Fixed Deposit Account**:
  - Interest rate: 15%
  - Minimum initial deposit: 100,000
  - Subsequent deposits must be at least 50,000.
  - Withdrawals are only allowed after the maturity period.
- **Student Account**:
  - Interest rate: 5%
  - No minimum balance requirement.
  - Maximum withdrawal limit: 10,000 per transaction.

### **Core Functionality**

- **Create Account**: Users can create a new account by selecting the account type (Student, Savings, or Fixed Deposit) and providing an account number.
- **Deposit Funds**: Users can deposit funds into an account. The deposit rules vary depending on the account type.
- **Withdraw Funds**: Users can withdraw funds from an account. The withdrawal rules vary depending on the account type.
- **Apply Interest**: Interest is applied to all accounts annually. The interest rate depends on the account type.
- **Query Deposit**: Users can query the current balance of an account.

## **Code Analysis**

### **Account.java**

- **Abstract Class**: `Account` is an abstract class with the following properties and methods:
  - `accountNumber`: Unique identifier for the account.
  - `balance`: The current balance of the account.
  - `getBalance()`: Returns the current balance.
  - `getAccountNumber()`: Returns the account number.
  - Abstract methods: `deposit(double amount)`, `withdraw(double amount)`, and `queryDeposit()`.

### **SavingsAccount.java**

- **Inherits from `Account`**:
  - Implements the `deposit`, `withdraw`, and `queryDeposit` methods.
  - Includes an `interestRate` of 10%.
  - Provides methods to calculate and apply interest (`calInterest()` and `applyInterest()`).

### **FixedDeposit.java**

- **Inherits from `Account`**:
  - Implements the `deposit`, `withdraw`, and `queryDeposit` methods.
  - Includes an `interestRate` of 15%.
  - Enforces a minimum initial deposit of 100,000 and subsequent deposits of at least 50,000.
  - Withdrawals are only allowed after the maturity period.

### **StudentAccount.java**

- **Inherits from `Account`**:
  - Implements the `deposit`, `withdraw`, and `queryDeposit` methods.
  - Includes an `interestRate` of 5%.
  - Enforces a maximum withdrawal limit of 10,000 per transaction.

### **Main.java**

- **Main Class**:
  - Handles user interaction through a menu-driven interface.
  - Provides options to create accounts, deposit funds, withdraw funds, apply interest, and query deposits.
  - Uses a static array to store up to 10 accounts.
  - Implements methods to search for accounts by account number.

## **Usage**

1. **Run the Program**: Execute the `Main` class to start the banking system.
2. **Menu Options**:
   - **1. Create New Account**: Create a new account by selecting the account type and providing an account number.
   - **2. Deposit Funds**: Deposit funds into an existing account.
   - **3. Withdraw Funds**: Withdraw funds from an existing account.
   - **4. INC (1 year passed)**: Apply interest to all accounts as if one year has passed.
   - **5. Query Deposit**: Query the current balance of an account.
   - **6. Quit**: Exit the program.

## **Limitations**

- The system supports a maximum of 10 accounts.
- The account data is not persisted between program runs.
- The system does not include error handling for invalid user inputs beyond basic checks.

## **Conclusion**

This simple banking management system demonstrates the use of object-oriented programming principles in Java, including inheritance, polymorphism, and encapsulation.
