package de.mathisneunzig.buchhaltung;

import java.util.ArrayList;

public class Main {
	
	private static ArrayList<Account> accounts;
	
	public static void main(String[] args) {
		
		accounts = new ArrayList<>();
		
		Entry grundstueckskauf = new Entry("Kauf eines Grundstuecks", 10000);
		Entry rohstoffkauf = new Entry("Kauf von Holz", 300);
		Entry inventurkorrektur = new Entry("Inventurkorrektur", 1000);
		
		ActiveAccount grundstuecke = new ActiveAccount(0510, "Bebaute Grundstücke");
		accounts.add(grundstuecke);
		grundstuecke.setOpeningStock(100000);
		grundstuecke.add(grundstueckskauf);
		
		ActiveAccount rohstoffe = new ActiveAccount(2000, "Rohstoffe / Fertigungsmaterial");
		accounts.add(rohstoffe);
		rohstoffe.setOpeningStock(20000);
		rohstoffe.add(rohstoffkauf);
		rohstoffe.remove(inventurkorrektur);
		
		ActiveAccount kasse = new ActiveAccount(2880, "Kasse");
		accounts.add(kasse);
		kasse.setOpeningStock(10000);
		kasse.remove(rohstoffkauf);
		
		PassiveAccount eigenkapital = new PassiveAccount(3000, "Eigenkapital");
		accounts.add(eigenkapital);
		eigenkapital.setOpeningStock(115000);
		eigenkapital.remove(inventurkorrektur);
		
		PassiveAccount darlehen = new PassiveAccount(4200, "Kurzfristige Bankverbindlichkeiten");
		accounts.add(darlehen);
		darlehen.setOpeningStock(15000);
		darlehen.add(grundstueckskauf);
		
		closeAccounts();
		printAccounts();
		
	}
	
	public static void closeAccounts() {
		for(Account a : accounts) {
			a.calculateClosingStock();
		}
	}
	
	public static void printAccounts() {
		for(Account a : accounts) {
			a.print();
			System.out.println();
		}
	}
	
}
