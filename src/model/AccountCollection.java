package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents a collection of accounts
 */
public class AccountCollection implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Account> accounts;
	
	/**
	 * An account collection is an array of accounts
	 */
	public AccountCollection() {
		this.accounts = new ArrayList<Account>();
	}
	
	/**
	 * Finds an account given login info
	 * 
	 * @param username Proposed username
	 * @param password Proposed password
	 * @return Returns the account if the login info exists or null if not
	 */
	public Account findAccount(String username, String password) {
		for (Account account : accounts) {
			String curUsername = account.getUsername();
			String curPassword = account.getPassword();
			if (username.equals(curUsername) && password.equals(curPassword)) {
				return account;
			}
		}
		return null;
	}
	
	/**
	 * checks if an account exists with the given username
	 * 
	 * @param username  the username to check if exists
	 * @return true if an account with the given username exists and false if not
	 */
	public boolean usernameTaken(String username) {
		for (Account account : accounts) {
			if (username.equals(account.getUsername())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Adds a new account to the collection
	 * 
	 * @param newAccount The account to be added
	 */
	public void add(Account newAccount) {
		this.accounts.add(newAccount);
	}
	
	/**
	 * Sets the contents of a collection of accounts given an array of accounts
	 * 
	 * @param accounts The array of accounts
	 */
	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts.clear();
		this.accounts.addAll(accounts);
	}
	
	/**
	 * @return The size of the account collection
	 */
	public int size() {
		return this.accounts.size();
	}
	
	/**
	 * Retrieve the account at a specific index
	 * 
	 * @param i The index
	 * @return The desired account
	 */
	public Account get(int i) {
		return accounts.get(i);
	}
}
