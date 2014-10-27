package model;

import java.util.List;
import model.dimension.*;


public class DimensionDetails {
	
	private OrientedDimension dimension;
	private List<String> selection;
	private Boolean isFull;
	
	public DimensionDetails(OrientedDimension dimension,
			List<String> selection, Boolean isFull) {
		super();
		this.dimension = dimension;
		this.selection = selection;
		this.isFull = isFull;
	}
	
	public OrientedDimension getDimension() {
		return dimension;
	}
	public void setDimension(OrientedDimension dimension) {
		this.dimension = dimension;
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
	public void setIsFull(Boolean isFull) {
		this.isFull = isFull;
	}
}
