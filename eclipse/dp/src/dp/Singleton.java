package dp;

public class Singleton {
	public int a;
	public int b;
	private Singleton()
	{
		a=10;
		b=20;
	}
	
	private static Singleton _instance = null;
	
	public static Singleton GetInstance()
	{
		if(_instance == null)
			_instance = new Singleton();
		return _instance;
	}
}
