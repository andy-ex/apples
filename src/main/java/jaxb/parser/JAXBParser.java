package jaxb.parser;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import model.Metadata;

public class JAXBParser {

	public Metadata parseMetadata(String path) {

		Metadata metadata = null;
		 try {
	 
			File file = new File("metadata.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Metadata.class);
	 
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			metadata = (Metadata) jaxbUnmarshaller.unmarshal(file);
	 
		  } catch (JAXBException e) {
			e.printStackTrace();
		  }
		 
		 return metadata;
	}
}
