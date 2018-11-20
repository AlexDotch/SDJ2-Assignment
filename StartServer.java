package player;

import java.rmi.Naming;
import java.rmi.RemoteException;

import jdk.jfr.events.FileWriteEvent;

public class StartServer
	{
		public static void main(String[] args) throws RemoteException
		{
			TTTServer s = new TicTacToeServer(new FileWriterAdapter());
			LocalRegistry.createRegistry(1099);
			Naming.bind("ttts", s);
			System.out.println("Server started");
		}

	}
