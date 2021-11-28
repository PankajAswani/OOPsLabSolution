package com.greatlearning.main;

import java.util.Scanner;
import com.greatlearning.model.*;
import com.greatlearning.service.*;

public class Driver {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String firstName, lastName, department = null;
		int choice;

		System.out.println("Please enter employee first name");
		firstName = scan.next();

		System.out.println("Please enter employee last name");
		lastName = scan.next();

		System.out.println("Please enter the department from the following");
		System.out.println("1. Technical");
		System.out.println("2. Admin");
		System.out.println("3. Human Resource");
		System.out.println("4. Legal");

		choice = scan.nextInt();

		switch (choice) {
		case 1:
			department = "tech";
			break;
		case 2:
			department = "admin";
			break;
		case 3:
			department = "hr";
			break;
		case 4:
			department = "legal";
			break;
		default:
			System.out.println("Wrong choice");
		}

		if (department != null) {
			Employee emp = new Employee(firstName, lastName, department);
			CredentialService credentials = new CredentialService();
			String email = credentials.generateEmailAddress(emp);
			String password = credentials.generatePassword();
			credentials.showCredentials(emp, email, password);
		}

		scan.close();
	}
}