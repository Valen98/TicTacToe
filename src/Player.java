import java.awt.Font;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Player {
	protected JPanel marker = new JPanel();
	protected JLabel markerText = new JLabel();

	private boolean playerTurn;
	Random rand = new Random();

	// randomize the playersTurn
	Player() {
		int chance = rand.nextInt(2);
		if (chance == 1) {
			this.playerTurn = true;
		} else {
			this.playerTurn = false;
		}
	}

	public boolean getPlayerTurn() {
		return this.playerTurn;
	}

	// Empty out the tile JLabel with "" text and returns the JLabel
	public JLabel paintMarker() {
		markerText.setText("");
		markerText.setFont(new Font("Monaco", Font.PLAIN, 120));
		return markerText;
	}

	public JLabel getMarker() {
		return this.markerText;
	}

	public void setPlayerTurn() {
		this.playerTurn = !playerTurn;
	}

	public JPanel getPlayerPanel() {
		return this.marker;
	}
}
