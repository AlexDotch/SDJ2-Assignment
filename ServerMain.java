package server_pack;

import java.io.IOException;

public class ServerMain
	{
		public static void main(String[] args) throws IOException
			{
				IntegerBlockingQueue ibq = new IntegerBlockingQueueImpl();
				Server s = new Server(ibq);
				s.start();
			}

	}
