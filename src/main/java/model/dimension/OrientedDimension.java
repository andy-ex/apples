package model.dimension;


public class OrientedDimension extends Dimension {

	private Orientation orientation;

	public OrientedDimension(String name, String infoColumnName, String idName,
			Orientation orientation) {
		super(name, infoColumnName, idName);
		this.orientation = orientation;
	}

	public OrientedDimension(String name, String infoColumnName, String idName) {
		super(name, infoColumnName, idName);
	}
	

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

}
