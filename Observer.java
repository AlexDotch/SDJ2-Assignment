package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Observer<T> extends Remote
	{
      public void notify (Observable obs , T arg) throws RemoteException;
	}
