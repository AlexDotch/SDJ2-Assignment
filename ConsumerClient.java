package client_pack;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

import server_pack.Request;

public class ConsumerClient implements Runnable
	{
		public ConsumerClient()
			{

			}

		@Override
		public void run()
			{
				try
					{
						Socket socket = new Socket("localhost", 888);
						Request request = new Request();

						ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());

						int resultFromServer;
						request.str = "take";

						outToServer.writeObject(request);

						ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
						String o = (String) inFromServer.readObject();

						request.result = Integer.parseInt(o);
						resultFromServer = request.result;

						System.out.println(o);
					}

				catch (IOException | ClassNotFoundException e)
					{
						System.out.println("Client fucked up");
					}
			}
	}
