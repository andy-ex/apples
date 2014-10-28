package jaxb.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class DimensionList {
	
	@XmlElement(name = "dimension")
	private List<DimensionEntry> entries = new ArrayList<DimensionEntry>();

	public List<DimensionEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<DimensionEntry> entries) {
		this.entries = entries;
	}

}
