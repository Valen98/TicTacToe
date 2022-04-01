
public class PlayFieldFactory{ 
	PlayFieldFactory() {
		Grid newGrid = new Grid();
		newGrid.createGrid();
		new Frame(newGrid);
	}
}
