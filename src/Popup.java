import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Popup extends JFrame implements ActionListener {
	private JButton restart;
	private JLabel winnerText = new JLabel("", SwingConstants.CENTER);
	private Grid grid;
	
	/***
	 * 
	 * @param winner gets current winner
	 * @param grid gets current grid so it can repaint it.
	 * Popup is a new JFrame which holds the current winner, the current score and a restart button.
	 */
	Popup(String winner, Grid grid) {
		this.grid = grid;
		new JFrame();
		restart = new JButton("Restart");
		JPanel winnerPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		restart.addActionListener(this);
		if(winner == "draw") {
			winnerText.setText("Its Draw!");

		}else {
			winnerText.setText(winner + " Won the game");
		}
		
		winnerPanel.setLayout(new BorderLayout());
		winnerPanel.add(winnerText, BorderLayout.NORTH);
		buttonPanel.add(restart);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout(5,5));
		add(winnerPanel, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.CENTER);
		setPreferredSize(new Dimension(300,300));
		setVisible(true);
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Dispose the current popup and repaints the grid.
		if(e.getSource() == restart) {
			dispose();
			grid.resetGrid();
			
		}
	}
}
