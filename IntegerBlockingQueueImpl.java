package server_pack;

import java.util.ArrayList;

public class IntegerBlockingQueueImpl implements IntegerBlockingQueue
	{
		// private ArrayList<Task> tasks;
		ArrayList<Integer> numbers = new ArrayList();

		public IntegerBlockingQueueImpl()
			{

			}

		@Override
		public void addNumber(int i)
			{

				numbers.add(i);
			}

		@Override
		public int retrieveNumbers()
			{
				// TODO Auto-generated method stub
				return numbers.get(numbers.size() - 1);

			}

		@Override
		public int size()
			{
				// TODO Auto-generated method stub
				return numbers.size();
			}

	}
