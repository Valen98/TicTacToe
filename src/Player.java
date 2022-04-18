import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Player {
	protected JPanel marker = new JPanel();
	protected JLabel markerText = new JLabel();
	
	private boolean playerTurn;
	Random rand = new Random();
	
	Player() {
		int chance = rand.nextInt(2);
		if(chance == 1) {
			this.playerTurn = true;
		}else {
			this.playerTurn = false;
		}
	}
	
	public boolean getPlayerTurn() {
		return this.playerTurn;
	}
	
	
	public String paintMarker() {
		System.out.println("Created Empty tile");
		markerText.setText("");
		//marker.add(markerText);
		return "";
	}
	
	public JLabel getMarker() {
		return this.markerText;
	}
	
	public void setPlayerTurn() {
		this.playerTurn = !playerTurn;
	}
	
	public JPanel getPlayerPanel() {
		//System.out.println("PLAYER");
		return this.marker;
	}
}
