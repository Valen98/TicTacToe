import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tile implements MouseListener {

	private Grid grid;
	JPanel tilePanel = new JPanel();
	JPanel playerPanel = new JPanel();
	JLabel markerText = new JLabel();

	private Player player;
	private PlayerX playerX;
	private PlayerO playerO;

	Tile(Grid grid, PlayerX playerX, PlayerO playerO, Player player) {
		this.playerX = playerX;
		this.playerO = playerO;
		this.player = player;
		player.paintMarker();
		;
		this.playerPanel = player.getPlayerPanel();

		this.grid = grid;
		tilePanel.setBorder(BorderFactory.createLineBorder(new Color(50, 50, 50)));
		tilePanel.addMouseListener(this);
		tilePanel.add(markerText);
		tilePanel.setBackground(new Color(120, 120, 120));
	}

	public void updateValue() {
		boolean playerTurn = player.getPlayerTurn();
		if (markerText.getText().equals("")) {
			if (playerTurn) {
				tilePanel.remove(this.playerPanel);
				setXMarker();

				// setPlayer(player);
			} else {
				tilePanel.remove(this.playerPanel);
				setOMarker();
				// setPlayer(player);
			}
			player.setPlayerTurn();
			tilePanel.repaint();
			tilePanel.revalidate();
			grid.updateTurn();
			grid.getWinner();
		}
	}

	public JPanel getTile() {
		return this.tilePanel;
	}

	public JLabel getMarker() {
		return this.markerText;
	}

	/***
	 * 
	 * @return this.Tile
	 */
	public Tile resetTile() {
		tilePanel.remove(markerText);
		markerText = player.paintMarker();
		tilePanel.add(markerText);
		tilePanel.repaint();
		tilePanel.revalidate();
		return this;
	}

	private void setXMarker() {
		markerText = playerX.paintMarker();
		tilePanel.add(markerText);
	}

	private void setOMarker() {
		markerText = playerO.paintMarker();
		tilePanel.add(markerText);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		updateValue();
		this.tilePanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (this.markerText.getText().equals("")) {
			this.tilePanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
			this.tilePanel.setBackground(new Color(150, 150, 150));
		} else {
			this.tilePanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		tilePanel.setBackground(new Color(120, 120, 120));

	}
}
