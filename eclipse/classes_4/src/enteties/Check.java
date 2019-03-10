package enteties;

public class Check {
	private String _chNumber;
	private String _bName;
	private int _depNumber;
	private float _amount;
	
	
	public Check(String chNumber, String bName, int depNumber, float amount)
	{
		this._chNumber = chNumber;
		this._bName = bName;
		this._depNumber = depNumber;
		this._amount = amount;
	}
	public Check()
	{
		this("UNKNOWN","UNKNOWN",0,0);
	}
	public String GetChNumber()
	{
		return this._chNumber;
	}
	public String GetBName()
	{
		return this._bName;
	}
	public int GetDerNumber()
	{
		return this._depNumber;
	}
	public float GetAmount()
	{
		return this._amount;
	}
	
	public void Print()
	{
		System.out.println(String.format("check num: %s, at bank %s dep num %d for %.2f", this._chNumber,this._bName,this._depNumber,this._amount));
	}
	public boolean equals(Object obj) {
		Check temp = (Check)obj;
		return this._chNumber.compareTo(temp.GetChNumber()) == 0 ? true : false;
	}
	@Override
	public void finalize() {
		System.out.println(String.format("check num: %s, at bank %s dep num %d for %.2f is about to be deleted", this._chNumber,this._bName,this._depNumber,this._amount));
	}
}
