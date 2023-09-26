package com.project.controller;

import java.util.Scanner;

import com.project.dto.UserDTO;
import com.project.service.UserService;
import com.project.service.impl.UserServiceImpl;

public class ProductController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private Scanner s = new Scanner(System.in);
	private int optionProd = 0;
	private UserService userService;

	{ // instance block

		do {
			System.out.println("1. Select 1 Add Product\\n\" + \"2. Select 2 Delete Product\\n\"\r\n"
					+ "+ \"3. Select 3 Update Product\\n\" + \"4. Select 4 to Show All Product\\n\"\r\n"
					+ "+ \"5. Select 5 to Show Any Product\\n\" + \"6. Select 6 for Exit");
			optionProd = s.nextInt();
			switch (optionProd) {
			case 1:
				addUser();
				System.out.println("Product Added");
				break;
			case 2:
				System.out.println("Product Deleted");
				break;
			case 3:
				System.out.println("Product Updated");
				break;
			case 4:
				System.out.println("All Product Shown");
				break;
			case 5:
				System.out.println("Any Product Shown");
				break;
			case 6:
				// s.close();
				System.out.println("Exited From Product");
				// break;
			}
		} while (optionProd != 6);

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
