// Account.java
// Account is an Observable class that represents a bank
// account in which funds may be deposited or withdrawn.
package com.chapter03.mvc.AccountManager;

import java.util.Observable;

public class Account extends Observable {

	// Account balance
	private double balance;

	// readonly Account name
	private String name;

	// Account constructor
	public Account(String accountName, double openingDeposit) {
		name = accountName;
		setBalance(openingDeposit);
	}

	// set Account balance and notify observers of change
	private void setBalance(double accountBalance) {
		balance = accountBalance;

		// must call setChanged before notifyObservers to
		// indicate model has changed
		setChanged();

		// notify Observers that model has changed
		notifyObservers();
	}

	// get Account balance
	public double getBalance() {
		return balance;
	}

	// withdraw funds from Account
	public void withdraw(double amount) throws IllegalArgumentException {
		if (amount < 0)
			throw new IllegalArgumentException(
					"Cannot withdraw negative amount");

		// update Account balance
		setBalance(getBalance() - amount);
	}

	// deposit funds in account
	public void deposit(double amount) throws IllegalArgumentException {
		if (amount < 0)
			throw new IllegalArgumentException("Cannot deposit negative amount");

		// update Account balance
		setBalance(getBalance() + amount);
	}

	// get Account name (readonly)
	public String getName() {
		return name;
	}
}