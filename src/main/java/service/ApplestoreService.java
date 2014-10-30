package service;

import java.io.File;
import java.util.List;
import java.util.Set;

import jaxb.parser.JAXBBuilder;
import model.DimensionDetails;
import model.Metadata;
import model.Report;
import model.dimension.Dimension;
import model.dimension.FixedDimension;
import model.dimension.Orientation;
import model.dimension.OrientedDimension;
import model.record.DimensionRecord;
import dao.ApplestoreDAO;

public class ApplestoreService {

    private Metadata metadata;
	private ApplestoreDAO applestoreDAO;
    
	public ApplestoreService() {
		metadata = JAXBBuilder.buildMetadata("metadata.xml");
		applestoreDAO = new ApplestoreDAO(metadata.getDatabaseUrl());
	}

    public Report generateReport(DimensionRecord fixedDimRecord,
                                 DimensionDetails hDimDetails,
                                 DimensionDetails vDimDetails) {
        Report report = new Report();
        
        FixedDimension fixedDim = new FixedDimension(metadata.getDimension(fixedDimRecord.getDimensionName()),  (fixedDimRecord.getValue()));
        report.setFixedDimension(fixedDim);
        report.setFixedDimensionRecord(fixedDimRecord);
        
        hDimDetails.setDimension(new OrientedDimension(metadata.getDimension(hDimDetails.getDimensionName()), hDimDetails.getOrientation()));
        vDimDetails.setDimension(new OrientedDimension(metadata.getDimension(vDimDetails.getDimensionName()), vDimDetails.getOrientation()));
     
        report.setHorizontalDimensionDetails(hDimDetails);
        report.setVerticalDimensionDetails(vDimDetails);

        report.setRecords(applestoreDAO.getReportRecords(fixedDimRecord.getDimensionName(), report.getFixedDimension(), hDimDetails, vDimDetails, metadata.getFact()));

        return report;
    }

    public List<DimensionRecord> getFixedDimensionRecords(String fixedDimensionName) {

    	Dimension fixedDim = metadata.getDimension(fixedDimensionName);
        return applestoreDAO.getDimensionValues(fixedDimensionName, fixedDim);
    }

    public List<DimensionRecord> getOrientedDimensionRecord(String dimensionName, Orientation orientation) {

        OrientedDimension orientedDim = new OrientedDimension(metadata.getDimension(dimensionName), orientation);
        return applestoreDAO.getDimensionValues(dimensionName, orientedDim);
    }
    
    public Metadata getMetadata() {
    	return metadata;
    }
    
    public Set<String> getDimensionNames() {
    	return metadata.getDimensionNames();
    }
    
    public void saveReport(Report report, File file) {
    	JAXBBuilder.saveReport(report, file);
    }
    
    public Report openReport(File file) {
    	return JAXBBuilder.buildReport(file);
    }

}
