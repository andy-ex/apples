package jaxb.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import model.dimension.Dimension;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DimensionEntry {

	@XmlAttribute
	private String dimensionName;
	@XmlElement(name="table")
	private Dimension dimension;
	
	public DimensionEntry() {
	}
	
	public DimensionEntry(String dimensionName, Dimension dimension) {
		super();
		this.dimensionName = dimensionName;
		this.dimension = dimension;
	}
	public String getDimensionName() {
		return dimensionName;
	}
	public void setDimensionName(String dimensionName) {
		this.dimensionName = dimensionName;
	}
	public Dimension getDimension() {
		return dimension;
	}
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}
	
}
