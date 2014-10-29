package model;

import java.util.List;

import model.dimension.*;


public class DimensionDetails {
	
	private String dimensionName;
	private Orientation orientation;
	private List<String> selection;
	private Boolean isFull = false;
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
