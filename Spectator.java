package player;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.org.apache.xerces.internal.util.URI.MalformedURIException;

public class Spectator extends JFrame implements Observer<Turn>
	{
		List<JLabel> lbls;
		
		public Spectator() throws RemoteException, MalformedURIException
		{
			UnicastRemoteObject.exportObject(this, 0);
			TTTServer ttts = (TTTServer) Naming.lookup("rmi://localhost:1099/ttts");
			ttts.addObserver(this);
			setupGUI();
		}
		
		private void setupGUI()
		{
			setSize(200, 200);
			
			lbls = new ArrayList<>(9);
			JPanel content = new JPanel (new GridLayout(3, 3, 5, 5));
			for(int i = 0; i < 9; i++)
				{
					JLabel lbl = new JLabel();
					lbl.setPreferredSize(new Dimension(40, 40));
					lbl.setMinimumSize(new Dimension(40, 40));
					lbls.add(lbl);
					content.add(lbl);
				}
			
			setContentPane(content);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
		}
		
		public void notify(Observable obs, Turn arg) throws RemoteException
		{
			lbls.get(arg.x + 3*arg.y).setText(arg.playerNumber);
		}
		

	}
