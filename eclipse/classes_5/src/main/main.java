package main;
import java.util.*;

import enteties.Film;
public class main {

	public static void main(String[] args) {
		//(int)(Math.random() * 20 + 5)
		Film[] films = new Film[13];
		for(int i = 0; i < films.length;i++)
		{
			films[i] = new Film(CreateName((int)(Math.random() * 5 + 1)/2 + 1 ),CreateName((int)(Math.random() * 10 + 5) / 2 + 1),(int)(Math.random() * 20 + 5));
		}
		/*
		for(Film f : films)
		{
			System.out.println(f.Print());
		}
		*/
		Rent(films,3);
		Rent(films,3);
		Rent(films,3);
		Rent(films,3);
		Rent(films,3);
		Rent(films,3);
		Rent(films,3);
		Rent(films,3);
		Rent(films,3);
		Rent(films,3);
		Rent(films,3);
		Rent(films,3);
		Rent(films,3);
		Rent(films,3);
		Rent(films,3);
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
	public static void Rent(Film[] films, int index)
	{
		Film temp = films[index];
		
		if(temp.Check())
		{
			temp.Remove();
			System.out.println(String.format("%s by %s was rented out, %s copies left", temp.GetName(),temp.GetDiractor(),temp.GetCopies()));
		}
		else
		{
			System.out.println(String.format("no more copies of %s by %s ", temp.GetName(),temp.GetDiractor()));
		}
	}
	public static void Return(Film[] films, int index)
	{
		Film temp = films[index];
		
		temp.Insert();
		System.out.println(String.format("%s by %s was rented out, %s copies left", temp.GetName(),temp.GetDiractor(),temp.GetCopies()));
	}
}
