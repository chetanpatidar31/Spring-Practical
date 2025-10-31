package com.rays.annotation;

import org.springframework.beans.factory.annotation.Value;

public class Inventory {

	@Value(value = "50")
	int stock = 0;

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int sold(int qty) {
		stock -= qty;
		return stock;
	}
}
