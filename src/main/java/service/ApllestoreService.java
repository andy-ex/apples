package service;

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

public class ApllestoreService {

    private Metadata metadata;
	private ApplestoreDAO applestoreDAO;
    
	public ApllestoreService() {
		metadata = JAXBBuilder.buildMetadata("metadata.xml");
		applestoreDAO = new ApplestoreDAO(metadata.getDatabaseUrl());
	}

    public Report generateReport(DimensionRecord fixedDimRecord,
                                 DimensionDetails hDimDetails,
                                 DimensionDetails vDimDetails) {
        Report report = new Report();
        
        FixedDimension fixedDim = (FixedDimension)metadata.getDimension(fixedDimRecord.getDimensionName());
        fixedDim.setFixedValue(fixedDimRecord.getValue());
        report.setFixedDimension(fixedDim);
        
        hDimDetails.setDimension(new OrientedDimension(metadata.getDimension(hDimDetails.getDimensionName()), hDimDetails.getOrientation()));
        hDimDetails.setDimension(new OrientedDimension(metadata.getDimension(hDimDetails.getDimensionName()), hDimDetails.getOrientation()));
     
        report.setHorizontalDimensionDetails(hDimDetails);
        report.setVerticalDimensionDetails(vDimDetails);

        report.setRecords(applestoreDAO.getReportRecords(report.getFixedDimension(), hDimDetails, vDimDetails, metadata.getFact()));

        return report;
    }

    public List<DimensionRecord> getFixedDimensionRecords(String fixedDimensionName) {

    	Dimension fixedDim = metadata.getDimension(fixedDimensionName);
        return applestoreDAO.getDimensionValues(fixedDim);
    }

    public List<DimensionRecord> getOrientedDimensionRecord(String dimensionName, Orientation orientation) {

        OrientedDimension orientedDim = new OrientedDimension(metadata.getDimension(dimensionName), orientation);
        return applestoreDAO.getDimensionValues(orientedDim);
    }
    
    public Metadata getMetadata() {
    	return metadata;
    }
    
    public Set<String> getDimensionNames() {
    	return metadata.getDimensionNames();
    }

}
