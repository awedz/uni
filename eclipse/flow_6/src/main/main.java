package main;
import java.util.*;
public class main {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("input a number");
		int A = ( Integer.parseInt(scnr.nextLine()));
		System.out.println("input a number");
		int B = ( Integer.parseInt(scnr.nextLine()));
		int temp;
		System.out.println(String.format("before swap A:%d B:%d", A,B));
		temp = A;
		A=B;
		B=temp;
		System.out.println(String.format("after swap A:%d B:%d", A,B));

	}

}
