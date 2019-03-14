package enteties;

public class Person {
	private String _name;
	private	int _id;
	private int _age;
	
	public Person(String name, int id, int age)
	{
		this._name = name;
		this._id = id;
		this._age = age;
	}
	public Person()
	{
		this("NA",0,0);
	}
	
	public String GetName()
	{
		return this._name;
	}
	public int GetId()
	{
		return this._id;
	}
	public int GetAge()
	{
		return this._age;
	}
	
}
