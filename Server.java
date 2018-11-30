package server_pack;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
	{
		private IntegerBlockingQueue ibq;

		public Server(IntegerBlockingQueue ibq)
			{
				this.ibq = ibq;
			}

		public void start() throws IOException
			{
				System.out.println("Started server.....");
				int i = 0;
				try
					{
						ServerSocket ss = new ServerSocket(888);
						while (true)
							{
								Socket socket = ss.accept();
								System.out.println("Accepted client");

								ClientHandler ch = new ClientHandler(this, socket, "T" + (++i));
								new Thread(ch).start();
							}
					} catch (Exception e)
					{

					}
			}

	}
