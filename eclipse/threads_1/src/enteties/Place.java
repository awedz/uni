package enteties;
import java.util.*;

import enteties.Person;
public class Place implements Runnable{

	private static Person _arr[]; 
	private static Person _mat[][];
	private boolean _res;
	private static int _place = 0, _x = 0, _y = 0;
	public Place()
	{
		_arr = new Person[10];
	}
	
	@Override
	public void run() {
		_res = false;
			//_res = AddPlaceArr(_MakePerson(),(int)(Math.random() * 10));			
	}
	
	public static synchronized void AddPlaceArr(Person p)
	{
		int place = (int)(Math.random() * 10);
		while(_arr[place] == null)
		{
			place = (int)(Math.random() * 10);
		}
		_arr[place] = _MakePerson();
	}
	public void PrintArr()
	{
		for(int i = 0;i<10;i++)
			System.out.println(_arr[i] != null ? i + " " + _arr[i].GetName() : i + " " + "empty" );
	}
	public static Person _MakePerson()
	{
		return new Person(CreateName(5),(int)(Math.random() * 900000 + 100000),(int)(Math.random() * 70 + 13));
	} 
	private static String CreateName(int lenth)
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
