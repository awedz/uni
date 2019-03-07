package main;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter first number");
		int num_1 = Integer.parseInt(scnr.nextLine());
		
		System.out.println("Enter second number");
		int num_2 = Integer.parseInt(scnr.nextLine());
		
		System.out.println(String.format("%d is bigger",num_1 > num_2 ? num_1 : num_2 ));

	}

}
