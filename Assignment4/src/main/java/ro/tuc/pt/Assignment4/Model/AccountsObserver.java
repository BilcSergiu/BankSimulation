package ro.tuc.pt.Assignment4.Model;

import java.util.Observable;

public class AccountsObserver extends Observable{
	
	 public void change(){ 
	        setChanged();
	        notifyObservers();
	    }
}
