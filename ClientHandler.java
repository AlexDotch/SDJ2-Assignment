package server_pack;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.sun.istack.internal.logging.Logger;

public class ClientHandler implements Runnable
	{
		private Server serv;
		private Socket socket;
		private String name;

		public ClientHandler(Server serv, Socket sock, String name)
			{
				this.serv = serv;
				socket = sock;
				this.name = name;
			}

		public void run()
			{
				try

					{
						ObjectInputStream inFromClient = new ObjectInputStream(socket.getInputStream());
						ObjectOutputStream outToClient = new ObjectOutputStream(socket.getOutputStream());
						IntegerBlockingQueueImpl queue = new IntegerBlockingQueueImpl();

						while (true)
							{
								Request.str = (String) inFromClient.readObject();

								if (Request.str.toLowerCase().equals("add"))
									{
										// int num = (int) inFromClient.readObject();
										Request.add = (int) inFromClient.readObject();
										// Logger.getInstance().log(name + " added " + Request.add);
										// serv.add(Request.add);

										queue.addNumber(Request.add);
									}
								if (Request.str.toLowerCase().equals("take"))
									{
										// int num = (int) inFromClient.readObject();
										Request.result = queue.retrieveNumbers();
										// Logger.getInstance().log(name + " added " + Request.add);
										// serv.add(Request.add);

									}
							}
					} catch (Exception e)
					{

					}
			}

	}
