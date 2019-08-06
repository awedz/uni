
public class Shio {
	
	private static Shio shop;
	
	private Shio()
	{
		
	}
	
	public Shio GetInsance()
	{
		if(shop == null)
			shop = new Shio();
		return shop;
	}

	
	private class PrivateShop
	{
		public int a;
		public int b;
	}
}
