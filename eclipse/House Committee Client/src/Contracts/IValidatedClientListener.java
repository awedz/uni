package Contracts;

import Enums.ClientType;

public interface IValidatedClientListener {
	void ValidatedListener(int cliendID,ClientType type);
}
