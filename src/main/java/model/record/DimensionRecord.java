package model.record;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DimensionRecord {

    @XmlElement
	private String dimensionName;
	private long id;
    @XmlElement
	private String value;

	public DimensionRecord() {
	}

    public DimensionRecord(String dimensionName, String value) {
        this.dimensionName = dimensionName;
        this.value = value;
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
