package enteties;

public class FreshAquarium extends Aquarium {
	private int _sweet_level;
	
	public FreshAquarium(int _volume, String _bar_Code, int _manufacture_year, int _rating,int sweet_level) {
		super(_volume, _bar_Code, _manufacture_year, _rating);
		this._sweet_level = sweet_level;
		//  Auto-generated constructor stub
	}
	
	public int getSweet_level() {
		return _sweet_level;
	}
	
	public void setSweet_level(int sweet_level) {
		this._sweet_level = sweet_level;
	}
	@Override
	public String toString() {
		return String.format("vol:%d code:%s man year:%d rating:%d water sweetness level:%d",this.get_volume(),this.get_bar_Code(),this.get_rating(),this._sweet_level);
	}
	@Override
	public boolean equals(Object freshAquarium) {
		FreshAquarium aq = (FreshAquarium)freshAquarium;
		return this._sweet_level == aq.getSweet_level();
	}
}
