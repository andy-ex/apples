package jaxb.model;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ForeigKeyMapAdapter extends XmlAdapter<ForeignKeyList, Map<String, String>> {
	
	@Override
	public Map<String, String> unmarshal(ForeignKeyList list) throws Exception {
		Map<String, String> retVal = new HashMap<String, String>();
		for (ForeignKeyEntry keyValue : list.getEntries()) {
			retVal.put(keyValue.getDimensionName(), keyValue.getKey());
		}
		return retVal;
	}

	@Override
	public ForeignKeyList marshal(Map<String, String> map) throws Exception {
		ForeignKeyList retVal = new ForeignKeyList();
		for (String key : map.keySet()) {
			retVal.getEntries().add(new ForeignKeyEntry(key, map.get(key)));
		}
		return retVal;
	}

}
