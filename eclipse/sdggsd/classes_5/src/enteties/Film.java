package enteties;
public class Film {
	private String _name;
	private String _diractor;
	private int _copies;
	
	public Film(String name, String diractor, int copies)
	{
		this._name = name;
		this._diractor = diractor;
		this._copies = copies;
	}
	public Film()
	{
		this("NA","NA",0);
	}
	public String GetName()
	{
		return this._name;
	}
	public String GetDiractor()
	{
		return this._diractor;
	}
	public int GetCopies()
	{
		return this._copies;
	}
	public void SetData(String name, String diractor, int copies)
	{
		this._name = name;
		this._diractor = diractor;
		this._copies = copies;
	}
	
	public String Print()
	{
		return String.format("film : %s by %s copies available %d", this._name,this._diractor,this._copies);
	}
	
	public void Insert()
	{
		this._copies +=1;
	}
	public void Insert(int amount)
	{
		this._copies += amount;
	}
	public boolean Check()
	{
		return this._copies > 0;
	}
	public boolean Check(int amount)
	{
		return this._copies - amount > 0;
	}
	public void Remove()
	{
		this._copies -=1;
	}
	public void Remove(int amount)
	{
		this._copies -= amount;
	}
	
	
}
