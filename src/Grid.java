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
	
	public JPanel getGridPanel() {
		return this.gridPanel;
	}
	
	public void getWinner() {
		
	}
	
}
