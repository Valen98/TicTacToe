import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Grid extends JPanel {

	private Tile[][] tiles;
	private Tile tile;
	private JPanel gridPanel = new JPanel();
	private JPanel titlePanel = new JPanel();
	private JPanel playPanel = new JPanel();
	private JLabel playersTurn = new JLabel("");
	private Player player = new Player();
	private PlayerX playerX = new PlayerX();
	private PlayerO playerO = new PlayerO();
	private GameLogic gameLogic = new GameLogic();

	public JPanel createGrid() {
		playersTurn.setText(getCurrentPlayer() + " Turn");
		titlePanel.add(playersTurn);
		gridPanel.setLayout(new BorderLayout());
		playPanel.setLayout(new GridLayout(3, 3));
		playPanel.setBackground(new Color(150, 150, 150));
		tiles = new Tile[3][3];
		for (int column = 0; column < 3; column++) {
			for (int row = 0; row < 3; row++) {
				tile = new Tile(this, playerX, playerO, player);
				tiles[column][row] = tile;
				playPanel.add(tile.getTile());
			}
		}
		gridPanel.add(titlePanel, BorderLayout.NORTH);
		gridPanel.add(playPanel, BorderLayout.CENTER);

		return gridPanel;
	}

	public void resetGrid() {
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 3; column++) {
				tile = tiles[row][column].resetTile();
			}
		}
	}
	
	public void updateTurn() {
		if(player.getPlayerTurn()) {
			playersTurn.setText("X Turn");
		}else {
			playersTurn.setText("O Turn");
		}
		titlePanel.repaint();
		titlePanel.revalidate();
	}
	
	public String getCurrentPlayer() {
		if (player.getPlayerTurn()) {
			return "X";
		} else {
			return "0";
		}
	}

	public JPanel getGridPanel() {
		return this.gridPanel;
	}

	public Tile[][] getTiles() {
		return tiles;
	}

	public void getWinner() {
		String winner = gameLogic.checkWinner(this);
		if (winner == "O") {
			new Popup(winner, this);
		} else if (winner == "X") {
			new Popup(winner, this);
		} else if (winner == "draw") {
			new Popup(winner, this);
		}
	}

}
