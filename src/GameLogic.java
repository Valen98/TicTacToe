
public class GameLogic {
	Grid grid;
	int counter = 0;
	Tile[][] tiles;
	int gridLayout = 3;
	
	public String checkWinner(Grid getGrid) {
		grid = getGrid;
		counter++;
		//this.gridLayout = grid.getGridLayout();
		this.tiles = grid.getTiles();
		if (!checkCol().equals("noWinner")) {
			counter = 0;
			return checkCol();
		} else if (!checkRow().equals("noWinner")) {
			counter = 0;
			return checkRow();
		} else if (!checkDiag().equals("noWinner")) {
			counter = 0;
			return checkDiag();
		} else if (counter >= 9) {
			counter = 0;
			return "draw";
		} else {
			return "noWinner";
		}
	}
	
	public String checkCol() {
		for (int i = 0; i < gridLayout; i++) {
			int xCol = 0;
			int oCol = 0;
			for (int c = 0; c < gridLayout; c++) {
				if (this.tiles[c][i].getMarker().getText().equals("X")) {
					xCol++;
				} else if (this.tiles[c][i].getMarker().getText().equals("O")) {
					oCol++;
				}
				if (xCol == 3) {
					return "X";
				} else if (oCol == 3) {
					return "O";
				}
			}
		}
		return "noWinner";
	}
	
	public String checkRow() {
		for (int i = 0; i < gridLayout; i++) {
			int xRow = 0;
			int oRow = 0;
			for (int j = 0; j < gridLayout; j++) {

				if (this.tiles[i][j].getMarker().getText().equals("X")) {
					xRow++;
				} else if (this.tiles[i][j].getMarker().getText().equals("O")) {
					oRow++;
				}
				if (xRow == 3) {
					return "X";
				} else if (oRow == 3) {
					return "O";
				}
			}
		}
		return "noWinner";
	}
	
	public String checkDiag() {
		int xHor = 0;
		int oHor = 0;
		int rXHor = 0;
		int rOHor = 0;
		int diagonallyCheck = 2;
		for (int i = 0; i < gridLayout; i++) {
			if (this.tiles[i][i].getMarker().getText().equals("X")) {
				xHor++;
			} else if (this.tiles[i][i].getMarker().getText().equals("O")) {
				oHor++;
			}
			if (i != 2) {
				if (this.tiles[diagonallyCheck][i].getMarker().getText().equals("X")) {
					rXHor++;
				} else if (this.tiles[diagonallyCheck][i].getMarker().getText().equals("O")) {
					rOHor++;
				}
				if (diagonallyCheck >= 1) {
					diagonallyCheck--;
				}
			} else {
				if (this.tiles[0][i].getMarker().getText().equals("X")) {
					rXHor++;
				} else if (this.tiles[0][i].getMarker().getText().equals("O")) {
					rOHor++;
				}
			}
			if (rXHor == 3) {
				return "X";
			} else if (rOHor == 3) {
				return "O";
			}
			if (xHor == 3) {
				return "X";
			} else if (oHor == 3) {
				return "O";
			}
		}
		return "noWinner";
	}
}
