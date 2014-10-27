package model;

public class Fact {

	private String name;
	private String horizontalDimensionKey;
	private String verticalDimensionKey;
	private String fixedDimensionKey;
	private String infoColumnName;
	
	
	public Fact(String name, String horizontalDimensionKey,
			String verticalDimensionKey, String fixedDimensionKey,
			String infoColumnName) {
		super();
		this.name = name;
		this.horizontalDimensionKey = horizontalDimensionKey;
		this.verticalDimensionKey = verticalDimensionKey;
		this.fixedDimensionKey = fixedDimensionKey;
		this.infoColumnName = infoColumnName;
	}
	
	public String getHorizontalDimensionKey() {
		return horizontalDimensionKey;
	}

	public void setHorizontalDimensionKey(String horizontalDimensionKey) {
		this.horizontalDimensionKey = horizontalDimensionKey;
	}

	public String getVerticalDimensionKey() {
		return verticalDimensionKey;
	}

	public void setVerticalDimensionKey(String verticalDimensionKey) {
		this.verticalDimensionKey = verticalDimensionKey;
	}

	public String getFixedDimensionKey() {
		return fixedDimensionKey;
	}

	public void setFixedDimensionKey(String fixedDimensionKey) {
		this.fixedDimensionKey = fixedDimensionKey;
	}

	public String getInfoColumnName() {
		return infoColumnName;
	}

	public void setInfoColumnName(String infoColumnName) {
		this.infoColumnName = infoColumnName;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
