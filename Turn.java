package player;

import java.io.Serializable;

public class Turn implements Serializable
	{
		public String playerNumber;
		public int x;
		public int y;
		
		public Turn(String playerNumber, int x, int y)
		{
			this.playerNumber = playerNumber;
			this.x = x;
			this.y = y;
		}

	}
