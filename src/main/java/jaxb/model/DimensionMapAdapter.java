package jaxb.model;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import model.dimension.Dimension;

public class DimensionMapAdapter extends XmlAdapter<DimensionList, Map<String, Dimension>> {
	
	@Override
	public Map<String, Dimension> unmarshal(DimensionList list) throws Exception {
		Map<String, Dimension> retVal = new HashMap<String, Dimension>();
		System.out.println(list.getEntries().size());
		for (DimensionEntry keyValue : list.getEntries()) {
			System.out.println(keyValue.getDimensionName());
			retVal.put(keyValue.getDimensionName(), keyValue.getDimension());
		}
		return retVal;
	}

	@Override
	public DimensionList marshal(Map<String, Dimension> map) throws Exception {
		DimensionList retVal = new DimensionList();
		for (String key : map.keySet()) {
			retVal.getEntries().add(new DimensionEntry(key, map.get(key)));
		}
		return retVal;
	}

}
