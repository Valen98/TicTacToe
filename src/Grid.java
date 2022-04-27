import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Grid extends JPanel {

	private Tile[][] tiles;
	private Tile tile;
	private int gridLayout = 3;
	private JPanel gridPanel = new JPanel();
	private JPanel playerPanel = new JPanel();
	private JPanel playFieldPanel = new JPanel();
	private JLabel playersTurn = new JLabel("");
	private Player player = new Player();
	private PlayerX playerX = new PlayerX();
	private PlayerO playerO = new PlayerO();
	private GameLogic gameLogic = new GameLogic();
	private int currentXScore = 0;
	private int currentOScore = 0;

	/***
	 * First sets the playersTurn JLabel to the players turn PlayerPanel is the
	 * playersTurn JLabel and the grid, playFieldPanel Creates a playFieldPanel with
	 * the gridLayout 3,3 Adds Tile to the playFieldPanel.
	 * 
	 */
	public JPanel createGrid() {
		playersTurn.setText(getCurrentPlayer() + " Turn");
		playerPanel.add(playersTurn);
		gridPanel.setLayout(new BorderLayout());
		playFieldPanel.setLayout(new GridLayout(gridLayout, gridLayout));
		playFieldPanel.setBackground(new Color(150, 150, 150));
		tiles = new Tile[gridLayout][gridLayout];
		for (int column = 0; column < gridLayout; column++) {
			for (int row = 0; row < gridLayout; row++) {
				tile = new Tile(this, playerX, playerO, player);
				tiles[column][row] = tile;
				playFieldPanel.add(tile.getTile());
			}
		}
		gridPanel.add(playerPanel, BorderLayout.NORTH);
		gridPanel.add(playFieldPanel, BorderLayout.CENTER);

		return gridPanel;
	}

	// Resets the title by setting each tile to tiles[][].resetTile()
	public void resetGrid() {
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 3; column++) {
				tile = tiles[row][column].resetTile();
			}
		}
	}

	// Updates the playerTurn title and repaints it

	public void updateTurn() {
		if (player.getPlayerTurn()) {
			playersTurn.setText("X Turn");
		} else {
			playersTurn.setText("O Turn");
		}
		playerPanel.repaint();
		playerPanel.revalidate();
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

	// If gameLogic.checkWinner returns other than "noWinner" it creates a new
	// instance of Popup and sends in winner + this which is the grid
	public void getWinner() {
		String winner = gameLogic.checkWinner(this);
		if (winner == "O") {
			currentOScore++;
			new Popup(winner, this, currentOScore, currentXScore);
		} else if (winner == "X") {
			currentXScore++;
			new Popup(winner, this, currentOScore, currentXScore);
		} else if (winner == "draw") {
			new Popup(winner, this, currentOScore, currentXScore);
		}
	}

}
