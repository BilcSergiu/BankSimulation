package ro.tuc.pt.Assignment4.Model;

import javax.swing.JOptionPane;

public class SpendingAccount extends Account {

	private double comision;

	public SpendingAccount(float val, Person pers) {
		super(val, pers);
		super.setId("Sp-" + Math.random() % 1000);
		comision = 0.5; // lei
	}

	public void addMoney(float val) {
		super.addMoney(val);
	}

	public void removeMoney(double val) {
		if(getValue() >= val) {
			System.out.println(val+comision);
			super.removeMoney(val + comision);
		}else {
			JOptionPane.showMessageDialog(null, "Not enough funds! ");
		}
	}

	public double getSuma() {
				setValue(getValue() - comision);
		return getValue();
	}
}
