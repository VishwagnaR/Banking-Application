package Banking;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

public class Bank {
	public static void main(String[] args) {
		System.out.println("*********Welcome to National Banking System*********");
		System.out.println("Do you want to open an account 1.Yes 2.No");
		Scanner sc = new Scanner(System.in);
		String choice = sc.nextLine();
		if (choice.equals("Yes")) {
			openAccount ac = new openAccount();
			ac.createAccount();
		}
		if (choice.equals("No")) {
			BankAccount ba = new BankAccount();
			System.out.println("\n");
			ba.showMenu();
		}
	}
}

class openAccount {
	String name;
	String dob;
	String bank;
	String accountType;
	int accountNum;

	void createAccount() {
		System.out.println("In which bank do you want to open it: 1.SBI 2.PNB 3.ICICI");
		Scanner sc = new Scanner(System.in);
		int choice1 = sc.nextInt();
		if (choice1 == 1) {
			bank = "SBI";
		}
		if (choice1 == 2) {
			bank = "PNB";
		}
		if (choice1 == 3) {
			bank = "ICICI";
		}
		System.out.println("Please enter your name:");
		sc.nextLine();
		name = sc.nextLine();

		System.out.println("Please enter your date of birth:");
		dob = sc.nextLine();
//		sc.nextLine();

		System.out.println("What type of account you want to open: 1.Saving 2.Current");
		int choice2 = sc.nextInt();
		if (choice2 == 1) {
			accountType = "Saving";
		}
		if (choice2 == 2) {
			accountType = "Current";
		}
		System.out.println("Your account has been opened with the following detials:");
		System.out.println("Bank: " + bank);
		System.out.println("Name: " + name);
		System.out.println("DOB: " + dob);
		System.out.println("Account Type: " + accountType);
		System.out.println("Account Number: " + Math.random());
		System.out.println("\n");
		BankAccount ba1 = new BankAccount();
		ba1.showMenu();
	}
}

class BankAccount {
	int balance;
	int previousTransaction;
	String accountType;
	double totalInterest;
	Scanner sc = new Scanner(System.in);

	void deposit(int amount) {
		if (amount != 0) {
			balance = balance + amount;
			System.out.println("Balance after deposit: " + balance);
			previousTransaction = amount;
		}
	}

	void withdraw(int amount) {
		if (amount != 0) {
			balance = balance - amount;
			System.out.println("Balance after deposit:" + balance);
			previousTransaction = -amount;
		}
	}

	void calculateInterest(double balance) {
		System.out.println("What type of account you have 1.Saving 2.Current");
		Scanner sc = new Scanner(System.in);
		int choice3 = sc.nextInt();
		if (choice3 == 1) {
			accountType = "Saving";
			double r = 0.05;
			int t;
			System.out.println("Enter your calculate interest");
			t = sc.nextInt();
			double finalAmount = balance * (1 + r * t);
			totalInterest = finalAmount - balance;
			System.out.println("Total interest earned is: " + totalInterest);
		}
		if (choice3 == 2) {
			accountType = "Current";
			double r = 0.08;
			int t, n;
			System.out.println("Enter your calculate interest");
			t = sc.nextInt();
			System.out.println("Enter the frequency that interest has been compound in a year");
			n = sc.nextInt();
			double finalAmount = balance * (Math.pow((1 + r / n), n * t));
			totalInterest = finalAmount - balance;
			System.out.println("Total interest earned is: " + totalInterest);
		}

	}

	void getPerviousTransaction() {
		FileOutputStream out;
		PrintStream p;
		try {
			out = new FileOutputStream("C:\\Users\\vishw\\eclipse-workspace\\Project_2");
			p = new PrintStream(out);
			if (previousTransaction > 0) {
				p.append("Deposited : ").append(String.valueOf(previousTransaction));
				System.out.println("Deposited : " + previousTransaction);
			} else if (previousTransaction < 0) {
				p.append("withdraw : ").append(String.valueOf(previousTransaction));
			} else {
				System.out.println("No transaction occurred ");
			}
			p.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	void showMenu() {
		char option = '\0';
		System.out.println("Welcome to the menu");
		System.out.println("\n");
		System.out.println("A. CheckBalance");
		System.out.println("B. Deposit Amount");
		System.out.println("C. Withdraw amount");
		System.out.println("D. See previous transaction");
		System.out.println("E. Calculate Interest");
		System.out.println("F. Exit");

		do {
			System.out.println("********************");
			System.out.println("Enter an option");
			System.out.println("********************");
			option = sc.next().charAt(0);
//			System.out.println("\n");

			switch (option) {
			case 'A':
				System.out.println("Balance = " + balance);
				System.out.println("\n");
				break;

			case 'B':
				System.out.println("Enter an amount to deposit");
				int depositAmount = sc.nextInt();
				deposit(depositAmount);
				System.out.println("\n");
				break;

			case 'C':
				System.out.println("Enter an amount to withdraw");
				int amountWithdraw = sc.nextInt();
				withdraw(amountWithdraw);
				System.out.println("\n");
				break;

			case 'D':
				getPerviousTransaction();
				System.out.println("\n");
				break;

			case 'E':
				calculateInterest(balance);
				System.out.println("\n");
				break;

			case 'F':
				break;

			default:
				System.out.println("Invalid input! Please enter again");
				break;
			}
		} while (option != 'F');
		System.out.println("Thank you for using our services");

	}
}
