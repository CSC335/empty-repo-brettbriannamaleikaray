package model;

import java.util.ArrayList;

public class AccountCollection {
	private ArrayList<Account> accounts;
	
	/**
	 * An account collection is an array of accounts
	 */
	public AccountCollection() {
		this.accounts = new ArrayList<Account>();
	}
	
	/**
	 * Sees if given login info exists
	 * 
	 * @param username Proposed username
	 * @param password Proposed password
	 * @return Returns true if the login info exists
	 */
	public boolean isValidLogin(String username, String password) {
		for (Account account : accounts) {
			String curUsername = account.getUsername();
			String curPassword = account.getPassword();
			if (username == curUsername && password == curPassword) {
				return true;
			}
		}
		return false;
	}
}
