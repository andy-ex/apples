package model;

import java.util.List;

import model.dimension.FixedDimension;
import model.record.ReportRecord;

public class Report {
	
	private FixedDimension fixedDimension;
	private DimensionDetails horizontalDimensionDetails;
	private DimensionDetails verticalDimensionDetails;
	private List<ReportRecord> records;
	
	
	public FixedDimension getFixedDimension() {
		return fixedDimension;
	}
	public void setFixedDimension(FixedDimension fixedDimension) {
		this.fixedDimension = fixedDimension;
	}
	public DimensionDetails getHorizontalDimensionDetails() {
		return horizontalDimensionDetails;
	}
	public void setHorizontalDimensionDetails(
			DimensionDetails horizontalDimensionDetails) {
		this.horizontalDimensionDetails = horizontalDimensionDetails;
	}
	public DimensionDetails getVerticalDimensionDetails() {
		return verticalDimensionDetails;
	}
	public void setVerticalDimensionDetails(
			DimensionDetails verticalDimensionDetails) {
		this.verticalDimensionDetails = verticalDimensionDetails;
	}
	public List<ReportRecord> getRecords() {
		return records;
	}
	public void setRecords(List<ReportRecord> records) {
		this.records = records;
	}
}
