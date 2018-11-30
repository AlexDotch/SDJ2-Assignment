package player;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PlayerView extends JFrame
	{
		private Controller ctrlr;
		private List<JButton> buttons;

		public PlayerView()
			{
				buttons = new ArrayList<>(9);
				initComponents();
			}

		private void initComponents()
			{
				setSize(200, 200);

				JPanel panel = new JPanel(new GridLayout(3, 3));

				int x = 0;
				int y = 0;

				for (int i = 0; i < 9; i++)
					{
						JButton btn = new JButton();

						panel.add(btn);

						buttons.add(btn);

						btn.setMinimumSize(new Dimension(50, 50));
						btn.setPreferredSize(new Dimension(50, 50));

						final int a = x;
						final int b = y;

						btn.addActionListener(e ->
							{
								ctrlr.attemptSetPiece(a, b);
								System.out.println("(" + a + "," + b + ")");
							});
						x++;
						if (x == 3)
							{
								y++;
								x = 0;

							}
					}

				setContentPane(panel);
				setVisible(true);
				setResizable(false);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				setLocationRelativeTo(null);
			}

		public void placePiece(String player, int x, int y)
			{
				buttons.get(x + 3 * y).setText(player);
			}

		public void setController(Controller controller)
			{
				this.ctrlr = controller;
			}

	}
