package ro.tuc.pt.Assignment4.Model;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

public class Account extends Observable implements Serializable {

	private String id;
	private double value;
	private Person person;

	public Account(float valoare, Person pers) {
		this.setValue(valoare);
		this.person = pers; 
	}

	public void addMoney(double value) {
		this.setValue(this.getValue() + value);
		this.notifyObservers(id);
	}

	public void removeMoney(double value) {
		if (this.getValue() < value) {
			JOptionPane.showMessageDialog(null, "Not enough funds!");
		} else {
			this.notifyObservers(id);
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

	public String toString(){
		return "Contul "+id+" al clientului: "+person.getCNP()+" a fost modificat!";
	}
	

}
