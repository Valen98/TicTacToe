public class GameLogic {
	Grid grid;
	int counter = 0;
	Tile[][] tiles;
	int gridLayout = 3;

	/***
	 * 
	 * @param getGrid  gets current Grid
	 * @param counter: If the counter gets equal or more than 9 its a draw. With
	 *                 other words the grid is full if any methods return other than
	 *                 "noWinner" it returns the result
	 * @return noWinner/X/O
	 */
	public String checkWinner(Grid getGrid) {
		grid = getGrid;
		counter++;
		// this.gridLayout = grid.getGridLayout();
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

	/***
	 * 
	 * Checks every column if they contain X or O. If it contains 1 X/O on 1 column
	 * then xCol/oCol gets +1 When xCol or oCol have 3 it then there are 3 X/O in
	 * one column
	 * 
	 * @return noWinner/X/O
	 */
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

	/***
	 * 
	 * Checks every row if they contain X or O. If it contains 1 X on 1 row then
	 * xRow gets +1 When xRow or oRow have 3 it then there are 3 X/O in one row
	 * 
	 * @return noWinner/X/O
	 */
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

	/**
	 * for loop first checks if the player has marker in tile[0][0] - tile[2][2]. If
	 * so the player has a top left to bottom right diagonal. xHor and oHor are
	 * markers in top left to right bottom. Second part checks if the player has
	 * marker in tile[2][0] - tile[0][0] which is bottom left and top right. if i =
	 * 2 it checks top right
	 * 
	 * @return noWinner/X/O
	 */
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
