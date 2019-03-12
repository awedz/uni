package shop;

public class Shop {
	private String _name;
	private double _banana;
	private double _apple;
	private double _orange;

	public Shop(String _name, double _banana, double _apple, double _orange) {
		this._name = _name;
		this._banana = _banana;
		this._apple = _apple;
		this._orange = _orange;
	}
	
	public Shop()
	{
		this("NA",0.0,0.0,0.0);
	}
	
	public String GetName() {
		return _name;
	}

	public double GetBanana() {
		return _banana;
	}

	public double GetApple() {
		return _apple;
	}

	public double GetOrange() {
		return _orange;
	}

	public void SetData(String Name, double Banana, double Apple, double Orange)
	{
		this._name = Name;
		this ._banana = Banana;
		this._apple = Apple;
		this._orange = Orange;
	}
	public void Print()
	{
		System.out.println(String.format("shop - %s with prices :\nbananas - %.1f\napples - %.1f\noranges - %.1f\n",
				this._name,
				this._banana,
				this._apple,
				this._orange));
	}
}
