package player;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Observable;

import com.sun.org.apache.xerces.internal.util.URI.MalformedURIException;

public class Player implements PlayerClient
	{
		TTTServer ttts;
		Controller ctrlr;
		
		public Player(Controller c) throws RemoteException, MalformedURIException
		{
			UnicastRemoteObject.exportObject(this, 0);
			ttts = (TTTServer) Naming.lookup("rmi://localhost:1099/ttts");
			ctrlr = c;
			ctrlr.setClient(this);
			ctrlr.registerPlayer(this);
			ctrlr.addObserver(this);
		}
		
		public void notify(Observable obs, Turn arg) throws RemoteException
		{
			ctrlr.setPiece(arg.playerNumber, arg.x, arg.y);
		}
		
		public void placePiece(String player, int x, int y)
		{
			try
				{
					ttts.makeMove(new Turn(player, x, y));
				}
			catch (RemoteException e)
				{
					e.printStackTrace();
				}
		}
		
		public void startGame(String player) throws RemoteException
		{
			ctrlr.setPlayer(player);
			ctrlr.setIsMyTurn(player.equalsIgnoreCase("X"));
			ctrlr.setGameIsStarted();
		}

	}
