package Message;

import java.io.Serializable;

import Enums.ClientType;
import Enums.ReqType;

public class LoginMessage extends Message    {
	public LoginMessage(ClientType ClientType, ReqType ReqType) {
		super(ClientType, ReqType);
		// TODO Auto-generated constructor stub
	}
	public String UserName;
	public String Pswd;
}
