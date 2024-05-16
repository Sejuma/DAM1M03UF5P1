package model;

import javax.swing.JTextField;

import main.Logable;

public class Employee extends Person implements Logable{
	
	private static final int USER = 123;
	private static final String PASSWORD = "test";

	public Employee(int employeeId, String password) {
		super();
	}

	public boolean login(int user, String password) {
		return user == USER && password.equals(PASSWORD);
	}

	@Override
	public boolean login(JTextField employeeId, JTextField PASSWORD) {
		return false;
	}
}