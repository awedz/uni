package main;

import dp.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton a = Singleton.GetInstance();
		Singleton b = Singleton.GetInstance();
		System.out.println(a.a);
		System.out.println(a.b);
		a.a = 100;
		System.out.println("--------");
		System.out.println(b.a);
		System.out.println(b.b);

	}

}
