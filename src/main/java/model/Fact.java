package model;

import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import jaxb.model.ForeigKeyMapAdapter;
@XmlRootElement(name = "fact")
@XmlAccessorType(XmlAccessType.FIELD)
public class Fact {

	@XmlElement
	private String name;
	@XmlElement
	private String infoColumnName;
	@XmlJavaTypeAdapter(ForeigKeyMapAdapter.class)
	@XmlElement(name = "foreignKeys")
	private Map<String, String> foreignKeysMap;
	
	
	public Map<String, String> getForeignKeysMap() {
		return foreignKeysMap;
	}

	public void setForeignKeysMap(Map<String, String> foreignKey) {
		this.foreignKeysMap = foreignKey;
		
	}

	public String getInfoColumnName() {
		return infoColumnName;
	}

	public void setInfoColumnName(String infoColumnName) {
		this.infoColumnName = infoColumnName;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getForeignKey(String dimensionName) {
		return foreignKeysMap.get(dimensionName);
	}
	
}
