package Server;

import java.util.List;

public interface GameLogger
	{
		public void logMove(String player, String move);
		public List <String> getGameMoves();
	}
