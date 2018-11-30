package client_pack;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;



public class ProducerMain
	{
		public static void main(String[] args) throws InterruptedException
			{

				Thread producer = new Thread(new ProducerClient());
				producer.start();

			}
	}
