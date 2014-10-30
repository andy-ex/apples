package model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import model.dimension.FixedDimension;
import model.record.DimensionRecord;
import model.record.ReportRecord;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Report {

	@XmlElement(name = "fixedDimensionRecord")
	private DimensionRecord fixedDimensionRecord;
	@XmlElement
	private DimensionDetails horizontalDimensionDetails;
	@XmlElement
	private DimensionDetails verticalDimensionDetails;

    private FixedDimension fixedDimension;

    private List<ReportRecord> records;


    public DimensionRecord getFixedDimensionRecord() {
        return fixedDimensionRecord;
    }

    public void setFixedDimensionRecord(DimensionRecord fixedDimensionRecord) {
        this.fixedDimensionRecord = fixedDimensionRecord;
    }

    public DimensionDetails getHorizontalDimensionDetails() {
        return horizontalDimensionDetails;
    }

    public void setHorizontalDimensionDetails(DimensionDetails horizontalDimensionDetails) {
        this.horizontalDimensionDetails = horizontalDimensionDetails;
    }

    public DimensionDetails getVerticalDimensionDetails() {
        return verticalDimensionDetails;
    }

    public void setVerticalDimensionDetails(DimensionDetails verticalDimensionDetails) {
        this.verticalDimensionDetails = verticalDimensionDetails;
    }

    public FixedDimension getFixedDimension() {
        return fixedDimension;
    }

    public void setFixedDimension(FixedDimension fixedDimension) {
        this.fixedDimension = fixedDimension;
    }

    public List<ReportRecord> getRecords() {
        return records;
    }

    public void setRecords(List<ReportRecord> records) {
        this.records = records;
    }
}
