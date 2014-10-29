package model.record;

public class DimensionRecord {
	
	private String dimensionName;
	private long id;
	private String value;

	public DimensionRecord() {
	}
	
	public DimensionRecord(long id, String value) {
		super();
		this.id = id;
		this.value = value;
	}
	
	
	public String getDimensionName() {
		return dimensionName;
	}


	public void setDimensionName(String dimensionName) {
		this.dimensionName = dimensionName;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

    @Override
    public String toString() {
    	return value;
    }
}
