import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerX extends Player{

	private JLabel markerText = new JLabel();
	private JPanel marker;
	
	PlayerX() {
		marker = super.marker;
		markerText = super.markerText;
	}
	
	@Override
	public void paintMarker() {
		System.out.println("PLAYERX");
		markerText.setText("X");
		markerText.setForeground (Color.blue);
		markerText.setFont(new Font("Monaco", Font.PLAIN, 120));
		marker.add(markerText);
	}
	public JLabel getMarker() {
		return this.markerText;
	}
}
