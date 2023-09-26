package com.project.controller;

import java.util.Scanner;

import com.project.dto.UserDTO;
import com.project.service.UserService;
import com.project.service.impl.UserServiceImpl;

public class UserController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private Scanner s = new Scanner(System.in);
	private int optionUser = 0;
	private UserService userService;

	{ // instance block

		do {
			System.out.println("1. Select 1 Add User\n" + "2. Select 2 Delete User\n" + "3. Select 3 Update User\n"
					+ "4. Select 4 to Show All User\n" + "5. Select 5 to Show Any User\n" + "6. Select 6 for Exit");
			optionUser = s.nextInt();
			switch (optionUser) {
			case 1:
				addUser();
				System.out.println("User Added");
				showAllUser();
				break;
			case 2:
				showAllUser();
				deleteUser();
				System.out.println("User Deleted");
				showAllUser();
				break;
			case 3:
				showAllUser();
				updateUser();
				System.out.println("User Updated");
				showAllUser();
				break;
			case 4:
				showAllUser();
				System.out.println("All Users Shown");
				break;
			case 5:
				searchUser();
				System.out.println("Any User Shown");
				break;
			case 6:
				// s.close();
				System.out.println("Exited From User");
				// break;
			}
		} while (optionUser != 6);

	} // instance block

	public void addUser() {
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

	private void deleteUser() {
		System.out.println("Enter Email of the User to be deleted: ");
		String email = s.next();

		//UserDTO user = new UserDTO(email);
		userService = new UserServiceImpl();
		boolean b = userService.deleteUser(email);
		if (b == true) {
			System.out.println("Data Deleted Successfully!");
		} else {
			System.out.println("Something Went Wrong" + "\n-----\nData Not Deleted Yet.");
		}
	}

	private void updateUser() {
		// TODO Auto-generated method stub
		System.out.println("Enter Email of the User to update: ");
		String email = s.next();

		System.out.println("Enter updated name:");
	    String name = s.next();

	    System.out.println("Enter updated password:");
	    String password = s.next();

	    System.out.println("Enter updated address:");
	    String address = s.next();
	    
	    UserDTO updatedUser = new UserDTO(name, email, password, address);
	    
		//UserDTO user = new UserDTO(email);
		userService = new UserServiceImpl();
		boolean b = userService.updateUser(updatedUser);
		if (b == true) {
			System.out.println("Data Updated Successfully!");
		} else {
			System.out.println("Something Went Wrong" + "\n-----\nData Not Updated Yet.");
		}

	}

	private void searchUser() {
		System.out.println("Enter Email of the User to be searched: ");
		String email = s.next();

		//UserDTO user = new UserDTO(email);
		userService = new UserServiceImpl();
		boolean b = userService.searchUser(email);
		if (b == true) {
			System.out.println("Data Displayed Successfully!");
		} else {
			System.out.println("Something Went Wrong" + "\n-----\nData Not Displayed Yet.");
		}
	}

	private void showAllUser() {
		// TODO Auto-generated method stub
		userService = new UserServiceImpl();
		boolean b = userService.showAllUser() != null;
		if (b == true) {
			System.out.println("Data Displayed Successfully!");
		} else {
			System.out.println("Something Went Wrong" + "\n-----\nData Not Displayed Yet.");
		}
	}

}
