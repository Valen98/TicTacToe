import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame{
	private JPanel titlePanel;
	private JLabel titleLabel;
	Frame(Grid grid) {
		new JFrame();
		this.setTitle("Tic-tac-toe");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(600, 600));
		this.setVisible(true);

		titlePanel = new JPanel();

		titleLabel = new JLabel("Tic-tac-toe");
		titlePanel.add(titleLabel);

		add(titlePanel, BorderLayout.NORTH);

		add(grid.getGridPanel());
		revalidate();
		repaint();
		pack();
	}
}
