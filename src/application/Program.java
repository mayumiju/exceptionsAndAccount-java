package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.WithdrawLimit;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter account data: ");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			String holder = sc.next();
			System.out.println("Initial balance: ");
			double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();

			Account account = new Account(number, holder, balance, withdrawLimit);

			System.out.println();
			System.out.print("Do you want to perform any procedure (y/n)?: ");
			char c = sc.next().charAt(0);
			if (c == 'y') {
				System.out.print("Deposit or withdraw (d/w)?: ");
				char procedure = sc.next().charAt(0);
				if (procedure == 'w') {
					System.out.print("Enter amount for withdraw: ");
					double amount = sc.nextDouble();
					account.withdraw(amount);
					System.out.println("New balance: " + account.getBalance());
				} else {
					System.out.print("Enter amount for deposit: ");
					double amount = sc.nextDouble();
					account.deposit(amount);
					System.out.println("New balance: " + account.getBalance());
				}
			} else {
				System.out.println("Have a nice day :)");
			}
		} catch (WithdrawLimit e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}
}
