package enteties;

public class SalAquarium extends Aquarium {
	private sl _salt_level;
	public static enum sl  { a,b,c}
	public SalAquarium(int volume, String bar_Code, int manufacture_year, int rating,sl _salt_level) {
		super(volume, bar_Code, manufacture_year, rating);
		// TODO Auto-generated constructor stub
	}
	public sl get_salt_level() {
		return _salt_level;
	}
	public void set_salt_level(sl salt_level) {
		this._salt_level = salt_level;
	}

}
