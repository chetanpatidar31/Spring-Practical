package com.rays.annotation;

import org.springframework.beans.factory.annotation.Value;

public class Payment {

	@Value(value = "900")
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
