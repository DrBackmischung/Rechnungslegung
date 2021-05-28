package de.mathisneunzig.buchhaltung;

public class ActiveAccount extends Account {
	
	private int id;
	private String name;
	private Entry[] soll; 
	private Entry[] haben;
	private double closingStock;

	public ActiveAccount(int id, String name) {
		super(id, name);
		this.name = name;
		this.id = id;
		haben = new Entry[0];
	}

	@Override
	public void add(Entry e) {
		Entry[] newEntries = new Entry[soll.length+1];
		for(int i = 0; i<soll.length; i++) {
			newEntries[i] = soll[i];
		}
		newEntries[newEntries.length-1] = e;
		soll = newEntries;
	}

	@Override
	public void remove(Entry e) {
		Entry[] newEntries = new Entry[haben.length+1];
		for(int i = 0; i<haben.length; i++) {
			newEntries[i] = haben[i];
		}
		newEntries[newEntries.length-1] = e;
		haben = newEntries;
	}

	@Override
	public void setOpeningStock(double amount) {
		soll = new Entry[1];
		soll[0] = new Entry("Opening Stock", amount);
	}

	@Override
	public void calculateClosingStock() {
		double d = getSollSum();
		Entry[] newEntries = new Entry[haben.length+1];
		for(int i = 0; i<haben.length; i++) {
			d -= haben[i].getAmount();
			newEntries[i] = haben[i];
		}
		newEntries[newEntries.length-1] = new Entry("Closing Stock", d);
		haben = newEntries;
		closingStock = d;
	}
	
	@Override
	public double getClosingStock() {
		return closingStock;
	}

	@Override
	public double getSollSum() {
		double d = 0;
		for(int i = 0; i<soll.length; i++) {
			d += soll[i].getAmount();
		}
		return d;
	}

	@Override
	public double getHabenSum() {
		double d = 0;
		for(int i = 0; i<haben.length; i++) {
			d += haben[i].getAmount();
		}
		return d;
	}

	@Override
	public void print() {
		System.out.println("=== Account: "+id+" | "+name+" ===");
		System.out.println("  Soll:");
		for(int i = 0; i<soll.length; i++) {
			System.out.println("    - "+soll[i].getName()+": "+soll[i].getAmount());
		}
		System.out.println("  Total: "+getSollSum());
		System.out.println("  Haben:");
		for(int i = 0; i<haben.length; i++) {
			System.out.println("    - "+haben[i].getName()+": "+haben[i].getAmount());
		}
		System.out.println("  Total: "+getHabenSum());
		System.out.println("=== Closing Stock: "+getClosingStock());
	}

}
