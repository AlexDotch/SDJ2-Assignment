package Server;
import player.Player;
import player.PlayerClient;
import player.Turn;
import spectator.Spectator;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Interfaces.Observable;

public interface TTTServer<Turn> extends Remote , Observable
	{
       public void registerPlayer(PlayerClient pc) throws RemoteException;
       public void makeMove(player.Turn tc) throws RemoteException;
	 
	   public void addObserver(Spectator spectator);
	   public void addObserver(Player player);
	
	}
