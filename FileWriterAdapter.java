package Server;

import java.util.List;

public class FileWriterAdapter  implements GameLogger 
	{
		WriteToFile writer = new WriteToFile();
		public FileWriterAdapter()
		{
			
		}

		@Override
		public void logMove(String player, String move)
			{
				writer.writeLine(player+move);
				
			}

		@Override
		public List<String> getGameMoves()
			{
				return writer.getAllLines();
				
			}
	}
