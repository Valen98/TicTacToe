import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class PlayerO extends Player {
	
	PlayerO() {
		marker = super.marker;
		markerText = super.markerText;
	}

	// Writes out the tile JLabel with "O", set text color to red and font Monaco
	// and returns the JLabel
	@Override
	public JLabel paintMarker() {
		markerText.setText("O");
		markerText.setForeground (Color.red);
		markerText.setFont(new Font("Monaco", Font.PLAIN, 120));
		return markerText;
	}
}
