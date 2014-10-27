package model.dimension;

public abstract class Dimension {
	
	protected String name;
	protected String infoColumnName;
	protected String idName;
	
	
	public Dimension(String name, String infoColumnName, String idName) {
		super();
		this.name = name;
		this.infoColumnName = infoColumnName;
		this.idName = idName;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfoColumnName() {
		return infoColumnName;
	}
	public void setInfoColumnName(String infoColumnName) {
		this.infoColumnName = infoColumnName;
	}
	public String getIdName() {
		return idName;
	}
	public void setIdName(String idName) {
		this.idName = idName;
	}
	
}
 