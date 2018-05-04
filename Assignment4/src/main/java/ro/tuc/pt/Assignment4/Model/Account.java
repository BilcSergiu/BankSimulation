package ro.tuc.pt.Assignment4.Model;

import java.io.Serializable;

import javax.swing.JOptionPane;

public class Account implements Serializable {

	private String id;
	private double value;
	private Person person;

	public Account(float valoare, Person pers) {
		this.setValue(valoare);
		this.person = pers; 
	}

	public void addMoney(double value) {
		this.setValue(this.getValue() + value);
	}

	public void removeMoney(double value) {
		if (this.getValue() < value) {
			JOptionPane.showMessageDialog(null, "Not enough funds!");
		} else {
			this.setValue(this.getValue() - value);
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void setValue(double value) {
		this.value = value;
	}

}
