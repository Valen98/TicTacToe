import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class PlayerX extends Player {

	PlayerX() {
		marker = super.marker;
		markerText = super.markerText;
	}

	// Writes out the tile JLabel with "X", set text color to blue and font Monaco
	// and returns the JLabel
	@Override
	public JLabel paintMarker() {
		markerText.setText("X");
		markerText.setForeground(Color.blue);
		markerText.setFont(new Font("Monaco", Font.PLAIN, 120));
		return markerText;
	}

}
