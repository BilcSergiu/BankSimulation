package ro.tuc.pt.Assignment4.Model;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

public class Person implements Serializable, Observer{
	private int CNP;
	private String name;
	private String phone;

	public Person(int cnp, String name, String phone) {
		this.CNP = cnp;
		this.name = name;
		this.phone = phone;
	}

	public int getCNP() {
		return CNP;
	}

	public void setCNP(int cNP) {
		CNP = cNP;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public void update(Observable o, Object arg) {
		JOptionPane.showMessageDialog(null, "Clientului: "+this.getCNP()+" i s-a modificat contul: "+arg);
		
	}
}
