import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerX extends Player{

	private JLabel markerText = new JLabel();
	
	PlayerX() {
		marker = super.marker;
		markerText = super.markerText;
	}
	
	@Override
	public String paintMarker() {
		System.out.println("PLAYERX");
		markerText.setText("X");
		markerText.setForeground (Color.blue);
		markerText.setFont(new Font("Monaco", Font.PLAIN, 120));
		return "X";
	}
	public JLabel getMarker() {
		return this.markerText;
	}
}
