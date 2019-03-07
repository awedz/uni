package main;
import java.util.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scnr = new Scanner(System.in);
		String input = scnr.nextLine();
		
		if(input.contains("."))
		{
			System.out.println(String.format("%.2f", Math.abs(Float.parseFloat(input))));
		}
		else
		{
			System.out.println(String.format("%d", Math.abs(Integer.parseInt(input))));
		}
	}
}