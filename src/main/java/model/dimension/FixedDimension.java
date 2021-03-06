package model.dimension;


public class FixedDimension extends Dimension {

	private String fixedValue;
	
	public FixedDimension() {
	}
	
	public FixedDimension(Dimension dimension, String fixedValue) {
		super (dimension.name, dimension.infoColumnName, dimension.idName);
		this.fixedValue = fixedValue;
	}
	
	public FixedDimension(String name, String infoColumnName, String idName) {
		super(name, infoColumnName, idName);
	}
	
	public FixedDimension(String name, String infoColumnName, String idName,
			String fixedValue) {
		super(name, infoColumnName, idName);
		this.fixedValue = fixedValue;
	}

	
	public String getFixedValue() {
		return fixedValue;
	}

	public void setFixedValue(String fixedValue) {
		this.fixedValue = fixedValue;
	}
}
