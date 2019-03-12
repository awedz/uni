package hotel;

public class Hotel {
	private String _Name;
	private String _City;
	private int _Rooms;
	private int _Free;
	
	public Hotel(String Name, String City, int Rooms, int Free) {
		this._Name = Name;
		this._City = City;
		this._Rooms = Rooms;
		this._Free = Free;
	}
	
	public Hotel() {
		this("NA","NA",0,0);
	}
	
	public String GetName() {
		return _Name;
	}
	
	public String GetCity() {
		return _City;
	}
	
	public int GetRooms() {
		return _Rooms;
	}
	
	public int GetFree() {
		return _Free;
	}
	public void Setfree(int newFreeRooms)
	{
		this._Free = newFreeRooms;
	}
	
	public void SetData(String name, String city, int rooms ,int free)
	{
		this._Name = name;
		this._City = city;
		this._Rooms = rooms;
		this._Free = free;
	}
	public void Print()
	{
		System.out.println(String.format("Hotel %s in %s has:%d of which %d is free %s", 
				this._Name, 
				this._City, 
				this._Rooms,
				this._Free, 
				((GetRooms() * 60)/100) > GetRooms() - GetFree() ? ",has 40% or more free rooms" : "" ));
	} 
	
}
