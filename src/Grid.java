import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class Grid{
	
	private Tile[][] tiles;
	private Tile tile;
	private JPanel gridPanel = new JPanel();
	Player player = new Player();
	PlayerX playerX = new PlayerX();
	PlayerO playerO = new PlayerO();
	GameLogic gameLogic = new GameLogic();
	
	public void createGrid() {
		gridPanel.setLayout(new GridLayout(3, 3));
		gridPanel.setBackground(new Color(150, 150, 150));
		tiles = new Tile[3][3];
		for(int column = 0; column < 3; column++) {
			for(int row = 0; row < 3; row++) {
				tile = new Tile(this, playerX, playerO, player);
				tiles[column][row] = tile;
				gridPanel.add(tile.getTile());
			}
		}
	}
	
	public void resetGrid() {
		for (int row = 0; row < 3; row++) {
			for (int column = 0; column < 3; column++) {
				tile = tiles[row][column].resetTile();
			}
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
			System.out.println("X WON!");
			new Popup(winner, this);
		} else if (winner == "draw") {
			System.out.println("DRAW");
			new Popup(winner, this);
		}
	}
	
}
