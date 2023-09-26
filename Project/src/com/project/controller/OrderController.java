package com.project.controller;

import java.util.Scanner;

import com.project.dto.UserDTO;
import com.project.service.UserService;
import com.project.service.impl.UserServiceImpl;

public class OrderController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private Scanner s = new Scanner(System.in);
	private int optionOrder = 0;
	private UserService userService;

	{ // instance block

		do {
			System.out.println(
					"1. Select 1 to Order Booking\n" + "2. Select 2 to Cancel Order\n" + "3. Select 3 for Exit");
			optionOrder = s.nextInt();
			switch (optionOrder) {
			case 1:
				System.out.println("Order Booked");
				break;
			case 2:
				System.out.println("Order Cancelled");
				break;
			case 3:
				// s.close();
				System.out.println("Exited From Order");
				// break;
			}
		} while (optionOrder != 6);

	} // instance block

	public void addUser() {
//		System.out.println("enter userid: ");
//		int userId = s.nextInt();

		System.out.println("Enter Name: ");
		String name = s.next();

		System.out.println("Enter Email: ");
		String email = s.next();

		System.out.println("Enter Password: ");
		String password = s.next();

		System.out.println("Enter Address: ");
		String address = s.next();

		UserDTO user = new UserDTO(name, email, password, address);
		userService = new UserServiceImpl();
		boolean b = userService.saveUser(user);
		if (b == true) {
			System.out.println("Data Saved Successfully!");
		} else {
			System.out.println("Something Went Wrong" + "\n-----\nData Not Saved Yet.");
		}

	}
}
