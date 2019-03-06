package Main;

import java.util.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("asdasd");
		ArrayList <Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		//lambda for each
		arr.forEach((n) -> System.out.println(n));
		//foreach
		for(Integer i : arr)
		{
			System.out.println(i);
		}
	}
	
}
