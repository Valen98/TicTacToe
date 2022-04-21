public class PlayerX extends Player {

	PlayerX() {
		marker = super.marker;
		markerText = super.markerText;
	}

	@Override
	public String paintMarker() {
		return "X";
	}

}
