package de.mathisneunzig.buchhaltung;

public class Entry {
	
	private String name;
	private double amount;
	
	public Entry(String name, double amount) {
		this.name = name;
		this.amount = amount;
	}
	
	public String getName() {
		return name;
	}
	
	public double getAmount() {
		return amount;
	}
	
}
