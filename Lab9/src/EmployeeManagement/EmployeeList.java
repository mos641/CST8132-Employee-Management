// Name: 		Mostapha A
// Class: 		CST8132
// Assessment:	Lab 
// Description: Contains the array lists of the employees, and manipulates the employees.

package EmployeeManagement;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Contains the array lists of the employees, and manipulates the employees.
 * 
 * @author Mostapha A
 * @version 1.0
 * @since 1.8
 * @see Development, Management, Manager, ITDeveloper, ITAnalyst
 */
public class EmployeeList {
	// array lists
	private ArrayList<Management> managers = new ArrayList<Management>();
	private ArrayList<Development> developers = new ArrayList<Development>();
	// Scanner for user input
	private Scanner input;
	// loop variable
	private boolean loop = true;

	/**
	 * Constructor to create the employee management system
	 * 
	 * @param input A scanner to be fed in so it can be closed at the end of the
	 *              main method.
	 */
	EmployeeList(Scanner input) {
		// set the scanner
		this.input = input;
	}

	/**
	 * Add an employee to an array list
	 */
	public void addEmployee() {
		//employee type
		String type;
		
		//header
		System.out.println("Enter details of the employee " + (managers.size()+developers.size()+1) + 
				"\n===============================");
		// ask for employee type, validate input
		do {
			// prompt
			System.out.print("Please select the type of employee you wish to add. \n"
					+ "Type (without quotations) 'm' for Manager or 'd' for IT Developer or 'a' for IT Analyst : ");

			// capture input
			type = input.nextLine();
			// if it a valid choice, set loop condition to exit loop
			if (type.equalsIgnoreCase("m") || type.equalsIgnoreCase("d") || type.equalsIgnoreCase("a")) {
				loop = false;
			} else {
				// else throw exception
				System.out.println("Invalid account type, try again.");
			}

		} while (loop == true);
		// reset loop variable
		loop = true;

		// determine which array object needs to be created based on account type
		if (type.equalsIgnoreCase("m")) {
			// if they selected Manager
			Manager manager = new Manager();
			manager.addEmployee(input);
			managers.add(manager);
		} else if (type.equalsIgnoreCase("d")) {
			// if they selected IT developer
			Development developer = new ITDeveloper();
			developer.addEmployee(input);
			developers.add(developer);
		} else {
			// if they selected IT analyst
			Development developer = new ITAnalyst();
			developer.addEmployee(input);
			developers.add(developer);
		}

	}

	/**
	 * Print the details of all the employees
	 */
	public void printEmployeeDetails() {
		// Header
		System.out.println("Employee Management System\n" + "******************\n" + "Number of Employees : "
				+ (managers.size() + developers.size()) + "\n\nList of Management Employees\n");
		// print each index of the managers array
		for (int i = 0; i < managers.size(); i++) {
			// print to console
			System.out.print(managers.get(i).toString() + "\n");
		}
		// print each index of the developers array
		System.out.println("\nList of Development Employees\n");
		for (int i = 0; i < developers.size(); i++) {
			// print to console
			System.out.print(developers.get(i).toString() + "\n");
		}
	}

	/**
	 * Update an email of a user specified employee
	 */
	public void updateEmail() {
		int id;
		int index = -1;
		boolean manager = true;
		// ask for Id, loop to validate
		do {
			// ask for input
			System.out.print("Enter the ID of the employee whose email needs to be update: ");

			// validate it is int
			while (!input.hasNextInt()) {
				System.out.println("This is not an integer, try again.");
				input.next();
			}

			// store the int
			id = input.nextInt();

			// validate it is positive
			if (id < 0) {
				System.out.println("Enter a positive value. Try again.");
			}

		} while (id < 0);

		// check the id to the available ones in managers list
		for (int i = 0; i < managers.size(); i++) {
			if (managers.get(i).mId == id) {
				index = i;
				i = managers.size();
				manager = true;
			}
		}

		// if the account was found in the managers array, skip checking developers
		if (index == -1) {
			for (int i = 0; i < developers.size(); i++) {
				if (developers.get(i).dId == id) {
					index = i;
					i = managers.size();
					manager = false;
				}
			}
		}

		// if the id was not found, display error message otherwise update the email
		if (index == -1) {
			System.out.println("Account not found. Returning to menu.");
		} else {
			System.out.print("Enter the new Email address of the employee");
			// if they were a manager or not
			if (manager == true) {
				managers.get(index).email = input.next();
				System.out.println("The new email address of " + managers.get(index).firstName + " "
						+ managers.get(index).lastName + " is:" + managers.get(index).email);
			} else {
				developers.get(index).email = input.next();
				System.out.println("The new email address of " + developers.get(index).firstName + " "
						+ developers.get(index).lastName + " is:" + developers.get(index).email);
			}
		}

	}

	/**
	 * Process through the employees and calculate their monthly salary
	 */
	public void monthlyPayroll() {
		// for formatting pay
		DecimalFormat format = new DecimalFormat("0.##");
		// to store pay
		double pay;
		
		// loop through arrays and calculate monthly salary
		// print and calculate the payroll of the managers array
		for (int i = 0; i < managers.size(); i++) {
			pay = (managers.get(i).salary / 12) * .8;
			System.out.println("Deposit " + format.format(pay) + "$ into " 
			+ managers.get(i).firstName + " " + managers.get(i).lastName + "'s bank account");
		}
		
		// print and calculate the payroll of the developers array
		for (int i = 0; i < developers.size(); i++) {
			pay = (developers.get(i).salary / 12) * .8;
			System.out.println("Deposit " + format.format(pay) + "$ into " 
			+ developers.get(i).firstName + " " + developers.get(i).lastName + "'s bank account");
		}

	}

	/**
	 * Display all employees managed by a specific manager/supervisor
	 */
	public void displayTeamEmployee() {
		//store input id
		int id;
		//index of manager
		int index = -1;
		
		//verify ID input
		do {
			// ask for input
			System.out.println("Enter the ID of the manager to display the members of his team");

			// validate it is int
			while (!input.hasNextInt()) {
				System.out.println("This is not an integer, try again. \nEnter the ID of the manager to display the members of his team");
				input.next();
			}

			// store the int
			id = input.nextInt();

			// validate it is positive
			if (id < 0) {
				System.out.println("Enter a positive value. Try again.");
			}

		} while (id < 0);
		
		//find the manager in the array list
		for (int i = 0; i < managers.size(); i++) {
			if (managers.get(i).mId == id) {
				index = i;
				i = managers.size();
			}
		}
		
		//if manager was not found display an error message, otherwise find developers with the same sId
		if(index == -1) {
			System.out.println("Manager not found. Returning to menu.");
		} else {
			System.out.println("Manager's Name: " + managers.get(index).firstName + " " + managers.get(index).lastName 
					+ "\nDetail info for the members of " + managers.get(index).team + " team:");
			for(int i = 0; i < developers.size(); i++) {
				if(developers.get(i).sId == id) {
					System.out.println(developers.get(i).toString());
				}
			}
		}

	}

}
