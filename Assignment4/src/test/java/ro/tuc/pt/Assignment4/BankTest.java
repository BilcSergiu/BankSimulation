package ro.tuc.pt.Assignment4;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ro.tuc.pt.Assignment4.Model.Account;
import ro.tuc.pt.Assignment4.Model.Bank;
import ro.tuc.pt.Assignment4.Model.Person;
import ro.tuc.pt.Assignment4.Model.SavingAccount;
import ro.tuc.pt.Assignment4.Model.SpendingAccount;

public class BankTest {

	Person p = new Person(1000, "Bilc Sergiu", "0262386765");
	Account a = new SpendingAccount(20, p);
	Account c = new SavingAccount(20, p);
	Bank b = new Bank();

	@Test
	public void test() {
		//testAddClient();
	}
	
	@Test
	public void testAddClient() {
		// verific ca se adauga o noua cheie
		assertFalse(b.getHashClients().containsKey(p.getCNP()));
		b.addPerson(p);
		assertTrue(b.getHashClients().containsKey(p.getCNP()));
	}
	
	@Test
	public void testAddAccount() {
		// verific ca se adauga o noua cheie
		b.addPerson(p);
		assertFalse(b.getHashAccounts().containsKey(p.getCNP()));
		b.addAccount(a);
		assertTrue(b.getHashAccounts().containsKey(p.getCNP()));

		// verific existenta contului la respectiva pozitie
		ArrayList<Account> arr = b.readAccount(p.getCNP());
		assertNotNull(arr);
	}

	@Test
	public void testRemoveAccount() {
		b.addPerson(p);
		Account a1 = new SavingAccount(10, p);
		b.addAccount(a);
		b.addAccount(a1);
		b.removeAccount(a);
		assertTrue(b.getHashAccounts().containsKey(p.getCNP()));
		ArrayList<Account> arr = b.readAccount(p.getCNP());
		assertNotNull(arr);
		assertEquals("1", Integer.toString(arr.size()));
		b.removeAccount(a1);
		//assertFalse(b.getHashAccounts().containsKey(p.getCNP()));
	}

	@Test
	public void testRemoveClient() {
		b.addPerson(p);
		assertTrue(b.getHashClients().containsKey(p.getCNP()));
		b.removePerson(p);
		assertFalse(b.getHashClients().containsKey(p.getCNP()));
	}
	


	@Test
	public void testAddMoney() {
		a.addMoney(20);
		assertEquals("40.0", Double.toString(a.getValue()));
		a.addMoney(10);
		assertEquals("50.0", Double.toString(a.getValue()));
		c.addMoney(25);
		assertEquals("45.0", Double.toString(c.getValue()));
		c.addMoney(100);
		assertEquals("145.0", Double.toString(c.getValue()));
	}

	@Test
	public void testRemoveMoney() {
		a.removeMoney(10);
		assertEquals("9.5", Double.toString(a.getValue()));
		c.removeMoney(10);
		assertEquals("10.0", Double.toString(c.getValue()));
	}


}
