package player;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.sun.org.apache.xerces.internal.util.URI.MalformedURIException;

public class StartPlayer
	{
		public static void main(String[] args) throws RemoteException , NotBoundException,MalformedURLException, MalformedURIException
			{
				 PlayerView view = new PlayerView();
				 Model m = new Model();
				 Controller c = new Controller(view, m);
				 Player pc = new Player(c);
			}

	}
