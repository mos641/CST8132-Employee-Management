// Name: 		Mostapha A
// Class: 		CST8132
// Assessment:	Lab 
// Description: This is an interface for an employee to be implemented elsewhere.

package EmployeeManagement;

import java.util.Scanner;

/**
 * This is an interface for an employee to be implemented elsewhere.
 *  
 * @author Mostapha A
 * @version 1.0
 * @since 1.8
 * @see
 */
interface Employee {
	
	/**
	 * Format all the information to a string.
	 * @return The string of all the information
	 */
	public String toString();
	
	/**
	 * Add an employee to the array list.
	 */
	public void addEmployee(Scanner input);

}
