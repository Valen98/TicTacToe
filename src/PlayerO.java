import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerO extends Player {
	private JLabel markerText = new JLabel();
	private JPanel marker;
	
	PlayerO() {
		marker = super.marker;
		markerText = super.markerText;
	}
	
	@Override
	public void paintMarker() {
		System.out.println("PLAYERO");
		markerText.setText("O");
		markerText.setForeground (Color.red);
		markerText.setFont(new Font("Monaco", Font.PLAIN, 120));
		marker.add(markerText);
	}
}
