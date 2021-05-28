package de.mathisneunzig.buchhaltung;

public abstract class Account {
	
	public Account(int id, String name) {
	}
	
	public abstract void add(Entry e);
	public abstract void remove(Entry e);
	public abstract void setOpeningStock(double amount);
	public abstract void calculateClosingStock();
	public abstract double getClosingStock();
	public abstract double getSollSum();
	public abstract double getHabenSum();
	public abstract void print();
	
}
