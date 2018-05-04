package ro.tuc.pt.Assignment4.Model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

public interface BancProc {

	/**
	 * @pre a!=null
	 * @invariant isWellFormed()
	 * @post sizeAc()==sizeAc()@pre+1
	 */
	public void addAccount(Account a);

	/**
	 * @pre a!=null&&containsAc(a.persoana.getCnp())
	 * @invariant isWellFormed()
	 * @post sizeAc()==sizeAc()@pre-1
	 */
	public void removeAccount(Account a);

	/**
	 * @pre key!=null
	 * @invariant isWellFormed()
	 * @post @nochange
	 */
	public ArrayList<Account> readAccount(Integer key);

	/**
	 * @pre !accountsAreEmpty()
	 * @invariant isWellFormed()
	 * @post @nochange
	 */
	public void writeAccounts(Hashtable<Integer, ArrayList<Account>> h);

	/**
	 * @pre !accountsAreEmpty()
	 * @invariant isWellFormed()
	 * @post @nochange
	 */
	public List<Account> allAccounts();

	/**
	 * @pre a!=null
	 * @invariant isWellFormed()
	 * @post sizeP()==sizeP()@pre+1
	 */
	public void addPerson(Person a);

	/**
	 * @pre a!=null&&containsP(a)
	 * @invariant isWellFormed()
	 * @post sizeP()==sizeP()@pre-1
	 */
	public void removePerson(Person a);

	/**
	 * @pre !clientsAreEmpty()
	 * @invariant isWellFormed()
	 * @post @nochange
	 */
	public void writePersons(Hashtable<Integer, Person> h);

	/**
	 * @pre !clientsAreEmpty()
	 * @invariant isWellFormed()
	 * @post @nochange
	 */
	public List<Person> allClients();
}
