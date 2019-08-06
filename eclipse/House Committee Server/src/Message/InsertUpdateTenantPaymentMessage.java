package Message;

import Enums.ClientType;
import Enums.ReqType;

public class InsertUpdateTenantPaymentMessage extends Message{

	public InsertUpdateTenantPaymentMessage(ClientType ClientType, ReqType ReqType) {
		super(ClientType, ReqType);
		// TODO Auto-generated constructor stub
	}
	
	private int _apartmentNum;
	private int _monthNum;
	private int _amount;
	
	
	public int getmonthNum() {
		return _monthNum;
	}
	public void setmonthNum(int _monthNum) {
		this._monthNum = _monthNum;
	}
	
	public int getamount() {
		return _amount;
	}
	public void setamount(int _amount) {
		this._amount = _amount;
	}
	
	public int getClientID() {
		return _apartmentNum;
	}
	public void setClientID(int apartmentNum) {
		this._apartmentNum = apartmentNum;
	}
}
