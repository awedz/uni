package src;

public class SpeakerTest {
	private int _num1;
	
	public int GetNum()
	{
		return _num1;
	}
	
	public SpeakerTest()
	{
		_num1=2;
	}
	
	public void UpdateNum(int newNum)
	{
		_num1=newNum;
	}
}
