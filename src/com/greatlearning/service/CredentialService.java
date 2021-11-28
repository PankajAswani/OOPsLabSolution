package com.greatlearning.service;

import java.util.Random;
import com.greatlearning.model.*;

public class CredentialService {
	public String generateEmailAddress(Employee emp) {
		String email = emp.getFirstName().toLowerCase() + emp.getLastName().toLowerCase() + "@" + emp.getDepartment()
				+ ".company.com";
		return email;
	}

	public String generatePassword() {
		Random random = new Random();
		String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String smallLetters = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "1234567890";
		String specialCharacters = "!@#$%^&*_-+=<>?/";
		String allowedCharacters = capitalLetters + smallLetters + numbers + specialCharacters;
		char[] password = new char[8];

		for (int i = 0; i < 8; i++) {
			int index = random.nextInt(allowedCharacters.length());
			password[i] = allowedCharacters.charAt(index);
		}

		return new String(password);
	}

	public void showCredentials(Employee emp, String email, String password) {
		System.out.println("Dear " + emp.getFirstName() + " your generated credentials are as follows");
		System.out.println("Email    ---> " + email);
		System.out.println("Password ---> " + password);
	}
}