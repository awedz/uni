package enteties;

public class Toy {
	private int _code;
	private String _group;
	private String _manufacturer;
	private int _year;
	
	public Toy(int code,String group,String manufacturer,int year)
	{
		this._code = code;
		this._group = group;
		this._manufacturer = manufacturer;
		this._year = year;
	}
	public Toy()
	{
		this(0,"NA","NA",0);
	}
	
	public int GetCode()
	{
		return this._code;
	}
	public String GetGroup()
	{
		return this._group;
	}
	public String GetManufacturer()
	{
		return this._manufacturer;
	}
	public int GetYear()
	{
		return this._year;
	}
	
	public void SetData(int code,String group,String manufacturer,int year)
	{
		this._code = code;
		this._group = group;
		this._manufacturer = manufacturer;
		this._year = year;
	}
	
	public String Print()
	{
		return String.format("barcode%d: game type%s: made by%s: for children above the age of: %d", 
				this._code,
				this._group,
				this._manufacturer,
				this._year);
	}



}
