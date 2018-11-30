package Server;

import java.rmi.RemoteException;
import java.rmi.server.RemoteObject;
import java.rmi.server.UnicastRemoteObject;

import player.Player;
import player.PlayerClient;
import player.Turn;
import spectator.Spectator;

public class TicTacToeServer implements TTTServer<Turn>  
	{
		private PlayerClient pc0, pc1;
		private GameLogger logger;
		
		public TicTacToeServer(GameLogger _logger) throws RemoteException 
		{
			UnicastRemoteObject.exportObject(this, 0);
			logger = _logger;
			
		}
		
		public void registerPlayer(PlayerClient pc) throws RemoteException
		{
			System.out.println("Player joined");
			if(pc0 == null)
				{
					pc0 = pc;
				}
			else 
				{
					pc1 = pc;
					pc0.startGame("X");
					pc1.startGame("O");
				}
		}

		@Override
		public void makeMove(Turn tc) throws RemoteException
			{
				logger.logMove(tc.playerNumber,"piece at" + tc.x + ", "+ tc.y + ",");
				notifyObservers(tc);
				
			}

		

		@Override
		public void addObserver(Player player)
			{
				// TODO Auto-generated method stub
				
			}

		@Override
		public void addObserver(Spectator spectator)
			{
				// TODO Auto-generated method stub
				
			}

		

	}

