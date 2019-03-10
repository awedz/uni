package main;

import hotel.Hotel;
import java.util.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int listSize = 10;
		ArrayList<Hotel> hotels = new ArrayList<Hotel>();
		Scanner scnr = new Scanner(System.in);
		String name = CreateName(3);
		String city = CreateName(3);
		for(int i = 0; i < listSize; i++)
		{

			int free = (int)(Math.random() * 200 + 50);
			int rooms = (int)(Math.random() * 200 + 50);
			name = CreateName(3);
			while(free > rooms)
			{
				free = (int)(Math.random() * 200 + 50);
				rooms = (int)(Math.random() * 200 + 50);
				city = CreateName(4);
			}
			hotels.add(new Hotel(name,city,rooms,free));
		}
		hotels.forEach((h) -> {
			h.Print();
		});
		
		System.out.println("in what city would you like to look?");
		String userInput = scnr.nextLine().toString();
		System.out.println(userInput);
		
		hotels.forEach((h) -> {
			if(userInput.equalsIgnoreCase(h.GetCity()))
				h.Print();
		});
	}
	//make random string by lenth
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
