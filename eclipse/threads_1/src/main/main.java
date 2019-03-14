package main;

import enteties.*;
public class main {

	public static void main(String[] args) {
		Place a1 = new Place();
		Place a2 = new Place();
		Place a3 = new Place();
		new Thread(()-> {
			a1.AddPlaceArr(a1._MakePerson());
			a2.AddPlaceArr(a1._MakePerson());
			a3.AddPlaceArr(a1._MakePerson());
		});
		new Thread(()-> {
			a1.AddPlaceArr(a1._MakePerson());
			a2.AddPlaceArr(a1._MakePerson());
			a3.AddPlaceArr(a1._MakePerson());
		});
		new Thread(()-> {
			a1.AddPlaceArr(a1._MakePerson());
			a2.AddPlaceArr(a1._MakePerson());
			a3.AddPlaceArr(a1._MakePerson());
		});
		a1.PrintArr();
	}

}
