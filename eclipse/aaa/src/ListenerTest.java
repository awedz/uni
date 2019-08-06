package src;

public class ListenerTest {
	
	IListenerTest _listener;
	
	public void SetListener(IListenerTest listener)
	{
		_listener=listener;
	}
	
	
	public void ActivateListener(int i)
	{
		_listener.ListenerTest(i);
	}
	
}
