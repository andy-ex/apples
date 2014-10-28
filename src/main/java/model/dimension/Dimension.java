package model.dimension;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Dimension {

	@XmlElement
	protected String name;
	@XmlElement
	protected String infoColumnName;
	@XmlElement
	protected String idName;

	public Dimension() {
	}
	
	public Dimension(String name, String infoColumnName, String idName) {
		super();
		this.name = name;
		this.infoColumnName = infoColumnName;
		this.idName = idName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfoColumnName() {
		return infoColumnName;
	}

	public void setInfoColumnName(String infoColumnName) {
		this.infoColumnName = infoColumnName;
	}

	public String getIdName() {
		return idName;
	}

	public void setIdName(String idName) {
		this.idName = idName;
	}

}
