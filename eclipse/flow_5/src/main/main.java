package main;
import java.util.*;
public class main {

	public static void main(String[] args) {
		int[] arr = {0,0,0};
		Scanner scnr = new Scanner(System.in);
		for(int i = 0;i<3;i++)
		{
			System.out.println("input a number");
			arr[i] = ( Integer.parseInt(scnr.nextLine()));
		}
		Arrays.sort(arr);
		System.out.println(String.format("%d", arr[1]));


	}

}
