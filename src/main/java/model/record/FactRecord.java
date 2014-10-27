package model.record;

public class FactRecord {
	
	private long horizontalDimensionId;
	private long verticalDimensionId;
	private long fixedDimensionId;
	private String fact;
	
	public FactRecord(long horizontalDimensionId, long verticalDimensionId,
			long fixedDimensionId, String fact) {
		super();
		this.horizontalDimensionId = horizontalDimensionId;
		this.verticalDimensionId = verticalDimensionId;
		this.fixedDimensionId = fixedDimensionId;
		this.fact = fact;
	}
	
	public long getHorizontalDimensionId() {
		return horizontalDimensionId;
	}
	public void setHorizontalDimensionId(long horizontalDimensionId) {
		this.horizontalDimensionId = horizontalDimensionId;
	}
	public long getVerticalDimensionId() {
		return verticalDimensionId;
	}
	public void setVerticalDimensionId(long verticalDimensionId) {
		this.verticalDimensionId = verticalDimensionId;
	}
	public long getFixedDimensionId() {
		return fixedDimensionId;
	}
	public void setFixedDimensionId(long fixedDimensionId) {
		this.fixedDimensionId = fixedDimensionId;
	}
	public String getFact() {
		return fact;
	}
	public void setFact(String fact) {
		this.fact = fact;
	}

}
