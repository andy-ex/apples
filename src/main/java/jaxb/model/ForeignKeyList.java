package jaxb.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ForeignKeyList {
	
	@XmlElement(name = "dimensionFK")
	private List<ForeignKeyEntry> entries = new ArrayList<ForeignKeyEntry>();

	public List<ForeignKeyEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<ForeignKeyEntry> entries) {
		this.entries = entries;
	}

}
