package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import model.dimension.Dimension;
import jaxb.model.DimensionMapAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Metadata {
	
	@XmlElement(name="databaseUrl")
	private String databaseUrl;
	@XmlJavaTypeAdapter(DimensionMapAdapter.class)
	@XmlElement(name = "dimensions")
	private Map<String, Dimension> dimensions = new HashMap<>();
	@XmlElement
	private Fact fact;
	private List<String> dimensionNames;


	public Metadata() {
	}
	
	public Map<String, Dimension> getDimensions() {
		return dimensions;
	}

	public String getDatabaseUrl() {
		return databaseUrl;
	}

	public void setDatabaseUrl(String databaseUrl) {
		this.databaseUrl = databaseUrl;
	}

	public void setDimensions(Map<String, Dimension> dimensions) {
		this.dimensions = dimensions;
	}
	
	public Fact getFact() {
		return fact;
	}

	public void setFact(Fact fact) {
		this.fact = fact;
	}
	
	public Set<String> getDimensionNames() {
		return dimensions.keySet();
	}

}
