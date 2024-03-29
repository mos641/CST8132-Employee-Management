// Name: 		Mostapha A
// Class: 		CST8132
// Assessment:	Lab 
// Description: Attributes and behaviours of a management employee.

package EmployeeManagement;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * This is an abstract class that implements Employee. Attributes and behaviours
 * of a management employee.
 * 
 * @author Mostapha A
 * @version 1.0
 * @since 1.8
 * @see Employee
 */
public abstract class Management implements Employee {
	/** Management employee ID */
	protected int mId;
	/** First name */
	protected String firstName;
	/** Last name */
	protected String lastName;
	/** Email */
	protected String email;
	/** Yearly salary */
	protected double salary;
	/** Team name */
	protected String team;

	/**
	 * No argument constructor to create objects
	 */
	Management() {

	}

	/**
	 * Returns a formatted string of all the information.
	 * 
	 * @return A formatted string of the employee information.
	 */
	public String toString() {
		// for formatting salary
		DecimalFormat format = new DecimalFormat("0.##");

		// add all the details to one string
		String details;
		details = "Name: " + firstName + " " + lastName + " | Employee ID: " + mId + " | Email:" + email
				+ " | Yearly Salary: " + format.format(salary);

		// return string
		return details;
	}

	/**
	 * Adds an employee with information from the users input.
	 */
	public void addEmployee(Scanner input) {
		// ask for name
		System.out.print("Enter first name of the manager: ");
		firstName = input.next();

		System.out.print("Enter last name of the manager: ");
		lastName = input.next();

		// loop for ID
		do {
			// ask for input
			System.out.print("Enter the ID of the manager: ");

			// validate it is int
			while (!input.hasNextInt()) {
				System.out.println("This is not an integer, try again.");
				input.next();
			}

			// store the int
			mId = input.nextInt();

			// validate it is positive
			if (mId < 0) {
				System.out.println("Enter a positive value. Try again.");
			}

		} while (mId < 0);

		// ask for email
		System.out.print("Enter the email of the manager: ");
		email = input.next();

		// loop for salary
		do {
			// ask for input
			System.out.print("Enter salary of the Employee: ");

			// validate it is double
			while (!input.hasNextDouble()) {
				System.out.println("This is not a double, try again.");
				input.next();
			}

			// store the double
			salary = input.nextDouble();

			// validate it is positive
			if (salary < 0) {
				System.out.println("Enter a positive value. Try again.");
			}

		} while (salary < 0);

		// ask for team name
		System.out.print("Enter the team name of the manager: ");
		team = input.next();

	}

}
