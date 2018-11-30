package player;

public class Model
	{
		private String[][] board =
			{
					{ "", "", "" },
					{ "", "", "" },
					{ "", "", "" } };
		private String player;

		public Model()
			{

			}

		public void putPiece(String playerNumber, int x, int y)
			{
				board[x][y] = playerNumber;
			}

		public String[][] getBoardInfo()
			{
				return board;
			}

		public void setPlayer(String s)
			{
				player = s;
			}

		public String getPlayer()
			{
				return player;
			}

	}
