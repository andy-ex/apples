package model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAttribute;


import model.dimension.Orientation;
import model.dimension.OrientedDimension;


@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DimensionDetails {
	
	@XmlElement
	private String dimensionName;
	@XmlElement
	private Orientation orientation;
	@XmlElementWrapper(name = "selection")
	@XmlElement(name="value")
	private List<String> selection;
	@XmlAttribute
	private Boolean isFull;
	private OrientedDimension dimension;
	

	public DimensionDetails() {
	}
	
	public DimensionDetails(String dimensionName, Orientation orientation) {
		super();
		this.dimensionName = dimensionName;
		this.orientation = orientation;
	}
	
	public String getDimensionName() {
		return dimensionName;
	}
	
	public void setDimensionName(String dimensionName) {
		this.dimensionName = dimensionName;
	}
	
	public Orientation getOrientation() {
		return orientation;
	}
	
	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
	
	public List<String> getSelection() {
		return selection;
	}
	
	public void setSelection(List<String> selection) {
		this.selection = selection;
	}
	
	public Boolean isFull() {
		return isFull;
	}
	
	public void setFull(Boolean isFull) {
		this.isFull = isFull;
	}
	
	public OrientedDimension getDimension() {
		return dimension;
	}

	public void setDimension(OrientedDimension dimension) {
		this.dimension = dimension;
	}
	
	public String getSelectionAsINExpression() {
		StringBuilder builder = new StringBuilder();
		builder.append("(");
		for (String item : selection) {
			builder.append("'" + item + "',");
		}
		builder.deleteCharAt(builder.length()-1);
		builder.append(")");
		
		return builder.toString();
	}
	
}
