package jaxb.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ForeignKeyEntry {

	@XmlAttribute
	private String dimensionName;
	@XmlValue
	private String key;
	
	
	public ForeignKeyEntry() {
	}
	
	public ForeignKeyEntry(String dimensionName, String key) {
		super();
		this.dimensionName = dimensionName;
		this.key = key;
	}

	public String getDimensionName() {
		return dimensionName;
	}

	public void setDimensionName(String dimensionName) {
		this.dimensionName = dimensionName;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
}
