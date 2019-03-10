package main;
import java.util.*;
import shop.*;
public class main {

	public static void main(String[] args) {		
		Shop[] shop = new Shop[13]; 
		
		for(int i = 0;i < shop.length ;i++)
		{
			shop[i] = CreateShop();
		}
		/*
		for(Shop s : shop)
		{s
			s.Print();
		}
		*/
		Cheapest(shop,3,3,3);
	}
	
	public static void Cheapest(Shop[] shops,int bananas,int apples, int oranges)
	{
		Shop temp = shops[0];
		int cheapest = (int)((shops[0].GetBanana() * bananas) + (shops[0].GetApple() * apples) + (shops[0].GetOrange() * oranges));
		for(Shop s : shops)
		{
			if((int)((s.GetBanana() * bananas) + (s.GetApple() * apples) + (s.GetOrange() * oranges)) < cheapest)
			{
				cheapest = (int)((s.GetBanana() * bananas) + (s.GetApple() * apples) + (s.GetOrange() * oranges));
				temp = s;
			}
		}
		temp.Print();
		System.out.println(String.format("chipest price :%d", cheapest));
		
	}
	
	public static Shop CreateShop()
	{
		return new Shop(CreateName(3),(double)(Math.random() * 20 + 5),(double)(Math.random() * 12 + 3),(double)(Math.random() * 10 + 2));
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
