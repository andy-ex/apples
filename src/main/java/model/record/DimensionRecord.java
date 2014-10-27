package model.record;

public class DimensionRecord {
	
	private long id;
	private String value;

	public DimensionRecord(long id, String value) {
		super();
		this.id = id;
		this.value = value;
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
        return String.format("id: %s, value: %s;", id, value);
    }
}
