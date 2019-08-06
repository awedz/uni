package Message;

import Enums.ClientType;
import Enums.ReqType;

public class GetTenantPymantsMessage extends Message {

	public GetTenantPymantsMessage(ClientType ClientType, ReqType ReqType) {
		super(ClientType, ReqType);
	}
	private int _clientID;
	
	public int getClientID() {
		return _clientID;
	}
	
	public void setClientID(int clientID) {
		this._clientID = clientID;
	}
}
