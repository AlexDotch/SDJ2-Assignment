package client_pack;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

import server_pack.Request;

public class ProducerClient implements Runnable
	{

		public ProducerClient()
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
						Random r2;
						r2 = new Random();
						int num2 = r2.nextInt(100);
						request.str = "add";
						request.add = num2;

						outToServer.writeObject(request);

						ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
						String o = (String) inFromServer.readObject();

						System.out.println(o);
					}

				catch (IOException | ClassNotFoundException e)
					{
						System.out.println("Client fucked up");
					}
			}
	}
