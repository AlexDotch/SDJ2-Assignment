package client_pack;

public class ConsumerMain
	{

		public static void main(String[] args) throws InterruptedException
			{

				Thread consumer = new Thread(new ConsumerClient());
				consumer.start();

			}

	}
