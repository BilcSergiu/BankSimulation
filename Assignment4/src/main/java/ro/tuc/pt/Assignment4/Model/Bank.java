package ro.tuc.pt.Assignment4.Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

import javax.swing.JOptionPane;

public class Bank implements BancProc, Serializable {

	private Hashtable<Integer, ArrayList<Account>> hashAccounts;
	private Hashtable<Integer, Person> hashClients;

	public Bank() {
		hashAccounts = new Hashtable<Integer, ArrayList<Account>>();
		hashClients = new Hashtable<Integer, Person>();
		if (restoreAccounts() != null) {
			hashAccounts = this.restoreAccounts();
		}
		if (restoreClients() != null) {
			hashClients = this.restoreClients();
		}
		// hashAccounts = this.restoreAccounts();
		// hashClients = this.restoreClients();
	}

	public void addAccount(Account a) {
		assert a != null : "Eroare addAccount";
		assert isWellFormed() : "Banca nu e bine formata!";
		int size = this.sizeAc();
		ArrayList<Account> accounts = hashAccounts.get(a.getPerson().getCNP());
		if (accounts == null) {
			accounts = new ArrayList<Account>();
		}
		accounts.add(a);
		hashAccounts.put(a.getPerson().getCNP(), accounts);
		assert isWellFormed() : "Banca nu e bine formata!";
		assert (size + 1 == this.sizeAc()) : "Eroare la adaugare unui nou cont!";

	}

	public void updateAccount(Account a) {
		assert a != null : "Eroare addAccount";
		assert isWellFormed() : "Banca nu e bine formata!";
		int size = this.sizeAc();
		ArrayList<Account> accounts = hashAccounts.get(a.getPerson().getCNP());
		System.out.println(a.getId());
		System.out.println(a.getPerson().getCNP());
		System.out.println(a.getValue());
		if (accounts == null) {
			accounts = new ArrayList<Account>();
		}
		for (Account acc : accounts) {
			if (acc.getId().equals(a.getId())) {
				acc = a;
			}
		}
		hashAccounts.put(a.getPerson().getCNP(), accounts);
		assert isWellFormed() : "Banca nu e bine formata!";
		assert (size + 1 == this.sizeAc()) : "Eroare la adaugare unui nou cont!";
	}

	public void removeAccount(Account a) {
		assert a != null : "Eroare removeAccount";
		assert this.containsAc(a.getPerson().getCNP()) : "Eroare removeAccount";
		assert isWellFormed() : "Banca nu e bine formata";
		int size = this.sizeAc();
		ArrayList<Account> accounts = hashAccounts.get(a.getPerson().getCNP());
		System.out.println(a.getId());
		accounts.remove(a);
		hashAccounts.put(a.getPerson().getCNP(), accounts);
		assert isWellFormed() : "Banca nu e bine formata";
		assert (size - 1 == this.sizeAc()) : "Eroare la stergerea unui nou cont!";
	}

	public ArrayList<Account> readAccount(Integer key) {
		assert key != null : "Cheia este null";
		assert isWellFormed() : "Banca nu e bine formata";
		return hashAccounts.get(key);
	}

	public void writeAccounts(Hashtable<Integer, ArrayList<Account>> h) {
		try {
			assert !hashAccounts.isEmpty() : "Eroare la serializare: hashtable vid";
			assert isWellFormed() : "Tabelul nu e bine format!(eroare scriere cont)";
			FileOutputStream file = new FileOutputStream("conturi.txt");
			ObjectOutputStream obj = new ObjectOutputStream(file);
			obj.writeObject(h);
			obj.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Eroare la serializare! " + e);
		}
	}

	public List<Account> allAccounts() {
		assert !hashAccounts.isEmpty() : "Eroare la serializare: hashtable vid";
		assert isWellFormed() : "Tabelul nu e bine format!(eroare scriere cont)";
		ArrayList<Account> accounts = new ArrayList<Account>();
		for (Integer key : hashAccounts.keySet()) {
			accounts.addAll(hashAccounts.get(key));
		}
		return accounts;
	}

	public Account getAccount(int cnp, String id) {
		List<Account> accounts = readAccount(cnp);
		for (Account acc : accounts) {
			if (acc.getId().equals(id)) {
				return acc;
			}
		}
		return null;
	}

	public void addPerson(Person a) {
		assert a != null : "Eroare addAccount";
		assert isWellFormed() : "Banca nu e bine formata!";
		int size = this.sizeP();
		hashClients.put(a.getCNP(), a);
		assert isWellFormed() : "Banca nu e bine formata!";
		assert (size + 1 == this.sizeP()) : "Eroare la adaugare unui nou cont!";

	}

	public void removePerson(Person a) {
		assert a != null : "Eroare removePerson";
		assert this.containsP(a.getCNP()) : "Eroare removePerson";
		assert isWellFormed() : "Banca nu e bine formata";
		int size = this.sizeP();

		hashAccounts.remove(a.getCNP());
		hashClients.remove(a.getCNP());
		assert isWellFormed() : "Banca nu e bine formata";
		assert (size - 1 == this.sizeP()) : "Eroare la stergerea unui nou cont!";

	}

	public void writePersons(Hashtable<Integer, Person> h) {
		try {
			assert hashClients.isEmpty() : "Eroare la serializare: hashtable vid";
			assert isWellFormed() : "Tabelul nu e bine format!(eroare scriere cont)";
			FileOutputStream file = new FileOutputStream("clienti.txt");
			ObjectOutputStream obj = new ObjectOutputStream(file);
			obj.writeObject(h);
			obj.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Eroare la serializare! " + e);
		}
	}

	public List<Person> allClients() {
		assert !hashAccounts.isEmpty() : "Eroare la serializare: hashtable vid";
		assert isWellFormed() : "Tabelul nu e bine format!(eroare scriere cont)";
		ArrayList<Person> accounts = new ArrayList<Person>();
		for (Integer key : hashClients.keySet()) {
			accounts.add(hashClients.get(key));
		}
		return accounts;
	}

	public Hashtable<Integer, ArrayList<Account>> getHashAccounts() {
		return hashAccounts;
	}

	public void setHashAccounts(Hashtable<Integer, ArrayList<Account>> hashAccounts) {
		this.hashAccounts = hashAccounts;
	}

	public Hashtable<Integer, Person> getHashClients() {
		return hashClients;
	}

	public void setHashClients(Hashtable<Integer, Person> hashClients) {
		this.hashClients = hashClients;
	}

	public boolean isWellFormed() {
		int nrAccounts, nrClients = 0;
		ArrayList<Account> accounts;
		ArrayList<Person> clients;
		
		Enumeration<Integer> keys2 = hashClients.keys();
		while (keys2.hasMoreElements()) {
			Integer key = (Integer) keys2.nextElement();
			nrClients++;
		}
		if ((nrClients != hashClients.size())) {
			return false;
		}

		Enumeration<Integer> keys = hashAccounts.keys();
		while (keys.hasMoreElements()) {
			Integer key = (Integer) keys.nextElement();
			System.out.println(key);
			if (hashClients.containsKey(key) == false) {
				return false;
			}
			accounts = hashAccounts.get(key);
			Iterator<Account> it = accounts.iterator();
			nrAccounts = 0;
			while (it.hasNext()) {
				Account account = it.next();
				// System.out.println(account.getPerson().getCNP()+" = "+key);
				if (account.getPerson().getCNP() != key) {
					return false;
				}
				nrAccounts++;
			}
			if (nrAccounts != accounts.size()) {
				return false;
			}
		}
		return true;
	}

	public Hashtable<Integer, Person> restoreClients() {
		try {
			FileInputStream file = new FileInputStream("clienti.txt");
			ObjectInputStream obj = new ObjectInputStream(file);
			@SuppressWarnings("unchecked")
			Hashtable<Integer, Person> h = (Hashtable<Integer, Person>) obj.readObject();
			obj.close();
			return h;
		} catch (Exception e) {
			System.out.print("err deserializare ");
			return null;
		}
	}

	public Hashtable<Integer, ArrayList<Account>> restoreAccounts() {
		try {
			FileInputStream file = new FileInputStream("conturi.txt");
			ObjectInputStream obj = new ObjectInputStream(file);
			@SuppressWarnings("unchecked")
			Hashtable<Integer, ArrayList<Account>> h = (Hashtable<Integer, ArrayList<Account>>) obj.readObject();
			obj.close();
			return h;
		} catch (Exception e) {
			System.out.print("err deserializare ");
			return null;
		}
	}

	public boolean containsAc(Integer cnp) {
		return this.hashAccounts.containsKey(cnp);
	}

	public boolean containsP(Integer cnp) {
		return this.hashClients.containsKey(cnp);
	}

	public boolean clientsAreEmpty() {
		return this.hashClients.isEmpty();
	}

	public boolean accountsAreEmpty() {
		return this.hashAccounts.isEmpty();
	}

	public int sizeP() {
		return hashClients.size();
	}

	public int sizeAc() {
		int size = 0;
		ArrayList<Account> accounts = new ArrayList<Account>();
		for (Integer key : hashAccounts.keySet()) {
			accounts = hashAccounts.get(key);
			for (Account account : accounts) {
				size++;
			}
		}
		return size;
	}
}
