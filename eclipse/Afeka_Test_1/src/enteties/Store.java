package enteties;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import enteties.SalAquarium.sl;

public class Store {

	private Map<String,ArrayList<Aquarium>> stock;
	Scanner scnr;
	private int _user_choice;
	private int count;
	public Store()
	{
		stock = new HashMap<String, ArrayList<Aquarium>>();
	}
	public int Menu()
	{
		scnr = new Scanner(System.in);
		System.out.println("Pick your choice:\n[1]Fresh water\n[2]Sweet Water\n[3]exit");
		_user_choice = Integer.parseInt(scnr.nextLine());
		scnr.close();
		return _user_choice;
	}
	public void AddAquarium(Aquarium newAquarium)
	{
		stock.putIfAbsent(newAquarium.get_bar_Code(), new ArrayList<Aquarium>());
		stock.get(newAquarium.get_bar_Code()).add(newAquarium);
	}
		
	public void DeleteAquarium(String barcode)
	{
		stock.remove(barcode);
	}
	public void PrintBestAquarium(int rate) throws IOException
	{
		FileWriter fr = new FileWriter("./tanks.txt");
		stock.forEach((k,v)-> {
			v.forEach((aq)-> {
				if(aq.get_rating() >= rate)
				{
					//write to file
					try {
						fr.write(aq.toString());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
		});
		fr.close();
	}
	public int HowMuchRate()
	{
		count = 0;
		stock.forEach((k,v)->{
			v.forEach((aq)->{
				if(aq.getClass().getName() == "SalAquarium")
				{
					SalAquarium temp =  (SalAquarium)aq;
					if(temp.get_salt_level() == sl.b || temp.get_salt_level() == sl.c )
						count+=1;
				}
			});
		});
		return count;
	}
	
}
