package jaxb.parser;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import model.Metadata;
import model.Report;

public class JAXBBuilder {

	public static Metadata buildMetadata(String path) {

		Metadata metadata = null;
		 try {
	 
			File file = new File(path);
			JAXBContext jaxbContext = JAXBContext.newInstance(Metadata.class);
	 
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			metadata = (Metadata) jaxbUnmarshaller.unmarshal(file);
	 
		  } catch (JAXBException e) {
			e.printStackTrace();
		  }
		 
		 return metadata;
	}
	
	public static void saveReport(Report report, File file) {

		 try {
			  
				JAXBContext jaxbContext = JAXBContext.newInstance(Report.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		 
				// output pretty printed
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		 
				jaxbMarshaller.marshal(report, file);
				jaxbMarshaller.marshal(report, System.out);
		 
		  } catch (JAXBException e) {
				e.printStackTrace();
		  }
	}
	
	public static Report buildReport(File file) {

		Report report= null;
		 try {
	 
			JAXBContext jaxbContext = JAXBContext.newInstance(Report.class);
	 
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			report = (Report) jaxbUnmarshaller.unmarshal(file);
	 
		  } catch (JAXBException e) {
			e.printStackTrace();
		  }
		 
		 return report;
	}
}
