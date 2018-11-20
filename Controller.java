package player;

public class Controller
	{
		private final Model model;
		private Player client;
		private PlayerView view;
		private boolean isMyTurn = false;
		private boolean gameIsStarted;

		public Controller(PlayerView v, Model m)
			{
				model = m;
				view = v;
				if (view != null)
					view.setController(this);
			}

		public void attemptSetPiece(int x, int y)
			{
				if (!gameIsStarted)
					{
						return;
					}

				if (!isMyTurn)
					{
						return;
					}

				if (isGameOver())
					{
						return;
					}
				if (isValid(x, y))
					{
						isMyTurn = false;
						client.placePiece(model.getPlayer(), x, y);
					}
			}

		private boolean isGameOver()
			{
				if (hasWon("X", model.getBoardInfo()))
					return true;
				if (hasWon("O", model.getBoardInfo()))
					return true;
				return false;
			}

		public boolean hasWon(String player, String[][] board)
			{
				out: for (int x = 0; x < 3; x++)
					{
						for (int y = 0; x < 3; y++)
							{
								if (board[x][y] == null || !board[x][y].equalsIgnoreCase(null))
									continue out;
							}
					}
				out: for (int x = 0; x < 3; x++)
					{
						for (int y = 0; x < 3; y++)
							{
								if (board[x][y] == null || !board[x][y].equalsIgnoreCase(null))
									continue out;
							}
					}
				return gameIsStarted;

			}

		public boolean isValid(int x, int y)
			{
				String[][] boardInfo = model.getBoardInfo();
				return boardInfo[x][y].isEmpty();
			}

		public void setPiece(String player, int x, int y)
			{
				if (!player.equalsIgnoreCase(model.getPlayer()))
					{
						isMyTurn = true;
					}

				model.putPiece(player, x, y);
				view.placePiece(player, x, y);
				if (hasWon(model.getPlayer(), model.getBoardInfo()))
					{
						System.out.println("I won!!!");
					}
			}

		public String getPlayer()
			{
				return model.getPlayer();
			}

		public void setPlayer(String p)
			{
				model.setPlayer(p);
			}

		public void setIsMyTurn(boolean b)
			{
				isMyTurn = b;
			}

		public void setGameIsStarted()
			{
				gameIsStarted = true;
			}

		public void setClient(Player client)
			{
				this.client = client;
			}

	}