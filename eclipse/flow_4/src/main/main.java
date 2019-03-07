package main;

import java.util.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Enter first number");
		arr.add( Integer.parseInt(scnr.nextLine()));
		
		System.out.println("Enter second number");
		arr.add( Integer.parseInt(scnr.nextLine()));
		
		System.out.println("Enter third number");
		arr.add( Integer.parseInt(scnr.nextLine()));
		
		Collections.sort(arr, Collections.reverseOrder());
		arr.forEach((n) -> System.out.println(String.format("%d", n)));

	}

}
