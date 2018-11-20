package player;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TicTacToeServer implements TTTServer
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

	}

