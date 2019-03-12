package enteties;

public class Item {
	private long _catalog;
	private String _name;
	private float _price;
	
	public Item(long catalog, String name, float price)
	{
		this._catalog = catalog;
		this._name = name;
		this._price = price;
	}
	public Item()
	{
		this(0,"NA",0);
	}
	
	public long GetCatalog()
	{
		return this._catalog;
	}
	public String GetName()
	{
		return this._name;
	}
	public float GetPrice()
	{
		return this._price;
	}
	
	public void SetData(long catalog, String name, float price)
	{
		this._catalog = catalog;
		this._name = name;
		this._price = price;
	}
	
	public void Print()
	{
		System.out.println(String.format("cat num : %l name : %s price : %.2f",this._catalog,this._name,this._price ));
	}
	
	public float Cost(int amount)
	{
		return this._price*amount;
	}
}
