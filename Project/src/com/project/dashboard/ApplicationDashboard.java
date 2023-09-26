package com.project.dashboard;

import java.util.*;

import com.project.controller.CartController;
import com.project.controller.OrderController;
import com.project.controller.ProductController;
import com.project.controller.UserController;

public class ApplicationDashboard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dashboard();
	}

	private static void dashboard() {
		Scanner s = new Scanner(System.in);
		int count = 0, option = 0;
		do {
			System.out.println("********************");
			System.out.println("Welcome to Dashboard\n********************");
			System.out.println("1. Select 1 for User\n" + "2. Select 2 for Product\n" + "3. Select 3 for Cart\n"
					+ "4. Select 4 for Order\n" + "5. Select 5 for Exit");
			option = s.nextInt();
			switch (option) {
			case 1:
				new UserController();
				break;
			case 2:
				new ProductController();
				break;
			case 3:
				new CartController();
				break;
			case 4:
				new OrderController();
				break;
			case 5:
				s.close();
				System.out.println("Exited Successfully");
				break;
			}
		} while (option != 5);
	}

}

//Welcome to Dashboard
//1. Select 1 for User
//2. Select 2 for Product
//3. Select 3 for Cart
//4. Select 4 for Order
//5. Select 5 for Exit

//Welcome to Dashboard
//1. Select 1 for User
//	1. Select 1 Add User
//	2. Select 2 Delete User
//	3. Select 3 Update User
//	4. Select 4 to Show All User
//	5. Select 5 to Show Any User
//	6. Select 6 for Exit
//2. Select 2 for Product
//    	1. Select 1 Add Product
//	2. Select 2 Delete Product
//	3. Select 3 Update Product
//	4. Select 4 to Show All Product
//	5. Select 5 to Show Any Product
//	6. Select 6 for Exit
//3. Select 3 for Cart
//    	1. Select 1 Add to Cart
//	2. Select 2 Delete From Cart
//	3. Select 3 for Exit
//4. Select 4 for Order
//    	1. Select 1 to Order Booking 
//	2. Select 2 to Cancel Order
//	3. Select 3 for Exit
//5. Select 5 for Exit
