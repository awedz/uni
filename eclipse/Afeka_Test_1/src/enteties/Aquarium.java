package enteties;

public class Aquarium {
	private int _volume;
	private String _bar_Code;
	private int _manufacture_year; 
	private int _rating;
	
	public Aquarium(int _volume, String _bar_Code, int _manufacture_year, int _rating) {
		this._volume = _volume;
		this._bar_Code = _bar_Code;
		this._manufacture_year = _manufacture_year;
		this._rating = _rating;
	}
	public int get_volume() {
		return _volume;
	}
	public void set_name(int _volume) {
		this._volume = _volume;
	}
	public String get_bar_Code() {
		return _bar_Code;
	}
	public void set_bar_Code(String _bar_Code) {
		this._bar_Code = _bar_Code;
	}
	public int get_manufacture_year() {
		return _manufacture_year;
	}
	public void set_manufacture_year(int _manufacture_year) {
		this._manufacture_year = _manufacture_year;
	}
	public int get_rating() {
		return _rating;
	}
	public void set_rating(int _rating) {
		this._rating = _rating;
	}
	
	public boolean IsLonger(int x)
	{
		return _volume > x;
	}

}
