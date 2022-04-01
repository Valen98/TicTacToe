import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tile implements MouseListener{
	
	private JLabel text = new JLabel();
	private Grid grid;
	JPanel tilePanel = new JPanel();
	JPanel playerPanel = new JPanel();
	
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
		tilePanel.add(playerPanel);
	}

	public void updateValue() {
		boolean playerTurn = player.getPlayerTurn();
		System.out.println(playerX.getMarker().getText() + " <- This is the marker");
		if(player.getMarker().getText() == "") {
			if(playerTurn) {
				tilePanel.remove(this.playerPanel);
				playerX.paintMarker();
				tilePanel.add(playerX.getPlayerPanel());
				
				//setPlayer(player);
			}else {
				tilePanel.remove(this.playerPanel);
				playerO.paintMarker();
				tilePanel.add(playerO.getPlayerPanel());;
				//setPlayer(player);
			}
			player.setPlayerTurn();
			grid.getWinner();
			tilePanel.repaint();
			tilePanel.revalidate();
		}
	}
	
	public JPanel getTile() {
		return this.tilePanel;
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
