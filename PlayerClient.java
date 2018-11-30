package player;

import java.rmi.RemoteException;

import Interfaces.Observer;

public interface PlayerClient extends Observer <Turn> 
	{
       void startGame(String player) throws RemoteException;
		
	}
