This Java console-based program simulates the functioning of the Rural Bank Account Management System (RBAMS), which was designed to satisfy the requirements set by the Rural Bank of Nepal (RBN). It implements basic banking facilities for both savings and current accounts, focusing on simplicity, security, and real-life constraints of banking.
Functionality:
•	Deposition and withdrawal of money.
•	Add periodic interest to a savings account.
•	Display account details.
•	Handle invalid input in a friendly manner.
•	Custom exception for insufficient balance:
Design:
1.	Abstraction
BankAccount is an abstract class that describes the common behavior of an account.
2.	Inheritance
SavingsAccount and CurrentAccount are two classes inherited from the base class BankAccount.
3.	Encapsulate
Data members are private/protected and accessed using getter/setter or methods.
4.	Polymorphism
BankAccount is an abstract class, and SavingsAccount and CurrentAccount are its child classes; therefore, it works with the references of the abstract class BankAccount. It manipulates data of the child classes SavingsAccount and CurrentAccount at runtime while implementing OCJP.
5.	Aggregation
Class Customer is an aggregation class that contains n numbers of objects of the BankAccount class. Custom Exception

InsufficientBalanceException is thrown when the withdrawal is more than the allowed balance or overdraft limit is hit.

File Structure:
src
•	Main.java                                        Main code file
•	BankAccount.java		                          	 Abstract base class
•	SavingsAccount.java                          	 	 Saving specific logic file
•	CurrentAccount.java                          		 Current account 
•	Customer.java                                    Customer holding multiple accounts
•	InsufficientBalanceException.java                Custom exception
