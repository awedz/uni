package hotel;

public class Hotel {
	private String _Name;
	private String _City;
	private int _Rooms;
	private int _Free;
	
	public Hotel(String _Name, String _City, int _Rooms, int _Free) {
		this._Name = _Name;
		this._City = _City;
		this._Rooms = _Rooms;
		this._Free = _Free;
	}
	public Hotel() {
		this("NA","NA",0,0);
	}
	public String get_Name() {
		return _Name;
	}
	public String get_City() {
		return _City;
	}
	public int get_Rooms() {
		return _Rooms;
	}
	public int get_Free() {
		return _Free;
	}
}
