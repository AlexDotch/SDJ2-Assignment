package server_pack;

import java.io.Serializable;

public class Request implements Serializable
	{
		public static String str;
		public static int add;
		public static int[] retrieve;
		public static int result;
		
		public static void setRetrieve(int[] rets)
		{
			retrieve = rets;
		}
		
		public static int[] getRetrieve ()
		{
			return retrieve;
		}

	}
