package model.record;


public class ReportRecord {

	private DimensionRecord horizontalRecord;
	private DimensionRecord verticalRecord;
	private DimensionRecord fixedRecord;
	private FactRecord factRecord;
	
	
	public DimensionRecord getHorizontalRecord() {
		return horizontalRecord;
	}
	public void setHorizontalRecord(DimensionRecord horizontalRecord) {
		this.horizontalRecord = horizontalRecord;
	}
	public DimensionRecord getVerticalRecord() {
		return verticalRecord;
	}
	public void setVerticalRecord(DimensionRecord verticalRecord) {
		this.verticalRecord = verticalRecord;
	}
	public DimensionRecord getFixedRecord() {
		return fixedRecord;
	}
	public void setFixedRecord(DimensionRecord fixedRecord) {
		this.fixedRecord = fixedRecord;
	}
	public FactRecord getFactRecord() {
		return factRecord;
	}
	public void setFact(FactRecord factRecord) {
		this.factRecord = factRecord;
	}
	
}
