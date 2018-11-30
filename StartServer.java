package Server;

import java.rmi.registry.LocateRegistry;
import java.net.MalformedURLException;
import java.rmi.*;

import jdk.jfr.events.FileWriteEvent;

public class StartServer extends TicTacToeServer
	{
		public StartServer(GameLogger _logger) throws RemoteException
		{
			super(_logger);
			// TODO Auto-generated constructor stub
		}

		public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException
			{
				TTTServer s = new TicTacToeServer(new FileWriterAdapter());
				LocateRegistry.createRegistry(1099);
				Naming.bind("ttts",  s);
				System.out.println("Server started");
			}

	}
