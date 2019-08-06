package Message;

import java.io.Serializable;

import Enums.ClientType;
import Enums.ReqType;

public class Message implements Serializable {
	public ClientType clientType;
	public ReqType reqType;

	public Message(ClientType ClientType, ReqType ReqType) {
		clientType = ClientType;
		reqType = ReqType;
	}
}
