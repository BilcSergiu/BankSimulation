package ro.tuc.pt.Assignment4.Model;

public class SavingAccount extends Account {

	private double dobanda;

	public SavingAccount(int val, Person pers) {
		super(val, pers);
		super.setId("Sa-" + Math.random() % 1000);
		dobanda = 0.2; 
	}

	public void addMoney(float val) {
		super.addMoney(val + dobanda * val);
	}
}
