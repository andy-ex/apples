package service;

import dao.ApplestoreDAO;
import model.DimensionDetails;
import model.Fact;
import model.Report;
import model.dimension.Dimension;
import model.dimension.FixedDimension;
import model.dimension.Orientation;
import model.dimension.OrientedDimension;
import model.record.DimensionRecord;

import java.util.List;

public class ApllestoreService {

    private ApplestoreDAO applestoreDAO = new ApplestoreDAO();

    public Report generateReport(FixedDimension fixedDimension,
                                 DimensionDetails horizontalDimensionDetails,
                                 DimensionDetails verticalDimensionDetails) {
        Report report = new Report();
        report.setFixedDimension(fixedDimension);
        report.setHorizontalDimensionDetails(horizontalDimensionDetails);
        report.setVerticalDimensionDetails(verticalDimensionDetails);

        //TODO create Fact
        //report.setRecords(applestoreDAO.getReportRecords(report.getFixedDimension(), horizontalDimensionDetails.getDimension(), verticalDimensionDetails.getDimension(), ));

        return report;
    }

    public List<DimensionRecord> getFixedDimensionRecords(String fixedDimensionName) {

        //TODO load meta-info
        String infoColumnName = "sort";
        String idName = "id";

        Dimension dimension = new FixedDimension(fixedDimensionName, infoColumnName, idName);


        return applestoreDAO.getDimensionValues(dimension);
    }

    public List<DimensionRecord> getOrientedDimensionRecord(String dimensionName, Orientation orientation) {

        //TODO load meta-info
        String infoColumnName = "sort";
        String idName = "id";

        Dimension dimension = new OrientedDimension(dimensionName, infoColumnName, idName, orientation);

        return applestoreDAO.getDimensionValues(dimension);
    }

}
