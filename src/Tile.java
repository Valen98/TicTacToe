import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tile implements MouseListener{
	
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
		player.paintMarker();;
		this.playerPanel = player.getPlayerPanel();
		
		this.grid = grid;
		tilePanel.setBorder(BorderFactory.createLineBorder(new Color(50,50,50)));
		tilePanel.addMouseListener(this);
		tilePanel.add(markerText);
	}

	public void updateValue() {
		boolean playerTurn = player.getPlayerTurn();
		System.out.println(playerX.getMarker().getText() + " <- This is the marker");
		if(markerText.getText().equals("")) {
			if(playerTurn) {
				tilePanel.remove(this.playerPanel);
				setXMarker();
				
				//setPlayer(player);
			}else {
				tilePanel.remove(this.playerPanel);
				setOMarker();
				//setPlayer(player);
			}
			player.setPlayerTurn();
			tilePanel.repaint();
			tilePanel.revalidate();
			grid.getWinner();
		}
	}
	
	public JPanel getTile() {
		return this.tilePanel;
	}
	
	public JLabel getMarker() {
		return this.markerText;
	}
	
	public Tile resetTile() {
		markerText.setText(player.paintMarker());
		return this;
	}
	
	public void setXMarker() {
		markerText.setText(playerX.paintMarker());
		markerText.setForeground (Color.blue);
		markerText.setFont(new Font("Monaco", Font.PLAIN, 120));
	}
	public void setOMarker() {
		markerText.setText(playerO.paintMarker());
		markerText.setForeground (Color.red);
		markerText.setFont(new Font("Monaco", Font.PLAIN, 120));
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		updateValue();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
