package com.rays.ioc;

public class Payment {

	double balance = 0;

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double makePayment(double amt) {
		balance -= amt;
		return balance;
	}

	public double deposit(double amt) {
		return balance += amt;
	}
}
