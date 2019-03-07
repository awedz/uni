package main;
import java.util.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter wage");
		int input_wage = Integer.parseInt(scnr.nextLine());
		
		System.out.println("Enter hours worked");
		int input_hours = Integer.parseInt(scnr.nextLine());
		
		System.out.println(String.format("total wage is %d",input_hours*input_wage ));
	}

}
