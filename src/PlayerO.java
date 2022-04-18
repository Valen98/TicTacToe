public class PlayerO extends Player {
	
	PlayerO() {
		marker = super.marker;
		markerText = super.markerText;
	}
	
	@Override
	public String paintMarker() {
		return "O";
	}
}
