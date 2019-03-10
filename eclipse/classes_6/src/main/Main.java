package main;

import java.util.Random;

import enteties.Toy;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//(int)(Math.random() * 20 + 5)
		
		
		Toy[] toys = new Toy[8];
		for(int i = 0; i < toys.length;i++)
		{
			toys[i] = new Toy((int)(Math.random() * 20000 + 5000),CreateName(5),CreateName(10),(int)(Math.random() * 10 + 1));
		}
		/*
		for(Toy t : toys)
		{
			System.out.println(t.Print());
		}
		*/
		GetToysByAge(toys, 3);
	}
	public static void GetToysByAge(Toy[] toys,int age)
	{
		for(Toy t : toys)
		{
			if(t.GetYear() >= age)
				System.out.println(t.Print());
		}
	}
	
	
	public static String CreateName(int lenth)
	{
	  int leftLimit = 97; // letter 'a'
	  int rightLimit = 122; // letter 'z'
	  int targetStringLength = lenth;
	  Random randLetter = new Random();
	  StringBuilder buffer = new StringBuilder(targetStringLength);
	  for (int i = 0; i < targetStringLength; i++) {
		  int randomLimitedInt = leftLimit + (int)(randLetter.nextFloat() * (rightLimit - leftLimit + 1));
	      buffer.append((char) randomLimitedInt);
	  }
	    return buffer.toString();
	}

}
