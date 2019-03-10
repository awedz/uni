package main;

import java.util.*;

import enteties.Check;

public class main {

	public static void main(String[] args) {
		//str - chnumber, str - bname, int - depnumber, float - amount
		int chSize = 10,bNameSize = 5;
		String temp = CreateName(chSize);
		 Check[] checks = {
				 new Check(CreateName(chSize),CreateName(bNameSize),(int)(Math.random() * 20 + 5),(float)(Math.random() * 20000 + 50000)+((float)(Math.random() * 20000 + 50000)%(float)(Math.random() * 20000 + 50000))),
				 new Check(CreateName(chSize),CreateName(bNameSize),(int)(Math.random() * 20 + 5),(float)(Math.random() * 20000 + 50000)+((float)(Math.random() * 20000 + 50000)%(float)(Math.random() * 20000 + 50000))),
				 new Check(CreateName(chSize),CreateName(bNameSize),(int)(Math.random() * 20 + 5),(float)(Math.random() * 20000 + 50000)+((float)(Math.random() * 20000 + 50000)%(float)(Math.random() * 20000 + 50000))),
				 new Check(temp,CreateName(bNameSize),(int)(Math.random() * 20 + 5),(float)(Math.random() * 20000 + 50000)+((float)(Math.random() * 20000 + 50000)%(float)(Math.random() * 20000 + 50000))),
				 new Check(CreateName(chSize),CreateName(bNameSize),(int)(Math.random() * 20 + 5),(float)(Math.random() * 20000 + 50000)+((float)(Math.random() * 20000 + 50000)%(float)(Math.random() * 20000 + 50000))),
				 new Check(CreateName(chSize),CreateName(bNameSize),(int)(Math.random() * 20 + 5),(float)(Math.random() * 20000 + 50000)+((float)(Math.random() * 20000 + 50000)%(float)(Math.random() * 20000 + 50000))),
				 new Check(temp,CreateName(bNameSize),(int)(Math.random() * 20 + 5),(float)(Math.random() * 20000 + 50000)+((float)(Math.random() * 20000 + 50000)%(float)(Math.random() * 20000 + 50000))),
				 new Check(CreateName(chSize),CreateName(bNameSize),(int)(Math.random() * 20 + 5),(float)(Math.random() * 20000 + 50000)+((float)(Math.random() * 20000 + 50000)%(float)(Math.random() * 20000 + 50000))),
				 new Check(CreateName(chSize),CreateName(bNameSize),(int)(Math.random() * 20 + 5),(float)(Math.random() * 20000 + 50000)+((float)(Math.random() * 20000 + 50000)%(float)(Math.random() * 20000 + 50000))),
				 new Check(CreateName(chSize),CreateName(bNameSize),(int)(Math.random() * 20 + 5),(float)(Math.random() * 20000 + 50000)+((float)(Math.random() * 20000 + 50000)%(float)(Math.random() * 20000 + 50000))),
				 new Check(CreateName(chSize),CreateName(bNameSize),(int)(Math.random() * 20 + 5),(float)(Math.random() * 20000 + 50000)+((float)(Math.random() * 20000 + 50000)%(float)(Math.random() * 20000 + 50000))),
				 new Check(CreateName(chSize),CreateName(bNameSize),(int)(Math.random() * 20 + 5),(float)(Math.random() * 20000 + 50000)+((float)(Math.random() * 20000 + 50000)%(float)(Math.random() * 20000 + 50000)))
		 };

		 
		 Check ch_tocheck = new Check(temp,CreateName(chSize),(int)(Math.random() * 20 + 5),(float)(Math.random() * 20000 + 50000)+((float)(Math.random() * 20000 + 50000)%(float)(Math.random() * 20000 + 50000)));
		 Search(checks, ch_tocheck);
	}
	public static void Search(Check[] checks,Check ch)
	{
		int found = 0;
		for(Check c : checks)
		{
			if(ch.equals(c))
			{
				System.out.println("Found");
				c.Print();
				found = 1;
			}
		}
		if(found<1)
		{
			System.out.println("check does not exists");			
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
