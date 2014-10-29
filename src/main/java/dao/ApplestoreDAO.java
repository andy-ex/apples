package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.DimensionDetails;
import model.Fact;
import model.dimension.Dimension;
import model.dimension.FixedDimension;
import model.record.DimensionRecord;
import model.record.FactRecord;
import model.record.ReportRecord;

public class ApplestoreDAO {

    private static String databaseUrl;
    
    public ApplestoreDAO(String dbUrl) {
    	databaseUrl = dbUrl; 
    }

	public List<DimensionRecord> getDimensionValues(String universalDimensionName, Dimension dim) {
		
		Connection conn = null;
		Statement stmt = null;
		
		List<DimensionRecord> values = new ArrayList<>();
		
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(databaseUrl);
			stmt = conn.createStatement();
			
			String query = "SELECT " + dim.getIdName() + ", " + dim.getInfoColumnName() + " FROM " + dim.getName() + ";";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
                String dimensionValue = rs.getString(dim.getInfoColumnName());
                DimensionRecord record = new DimensionRecord(rs.getLong(dim.getIdName()), dimensionValue);
                record.setDimensionName(universalDimensionName);
                values.add(record);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return values;
	}
	
	public List<ReportRecord> getReportRecords(FixedDimension fixed, DimensionDetails hDimDetails, DimensionDetails vDimDetails, Fact fact) {
		
		Connection conn = null;
		Statement stmt = null;
		
		List<ReportRecord> records = new ArrayList<ReportRecord>();
		
		try {
			Class.forName("org.sqlite.JDBC");

            conn = DriverManager.getConnection(databaseUrl);
            
			stmt = conn.createStatement();
			String query = "SELECT * FROM " + fact.getName() + " fact " 
						+ "join " + fixed.getName() + " f on fact." + fact.getForeignKey(fixed.getName())  + "=f." + fixed.getIdName()
						+ " join " + hDimDetails.getDimension().getName() + " h on fact." + fact.getForeignKey(hDimDetails.getDimensionName()) + "=h." + hDimDetails.getDimension().getIdName()
						+ " join " + vDimDetails.getDimension().getName() + " v on fact." + fact.getForeignKey(vDimDetails.getDimensionName()) + "=v." + vDimDetails.getDimension().getIdName()
						+ " where f." + fixed.getInfoColumnName() + "=\"" + fixed.getFixedValue() + "\";";
			ResultSet rs = stmt.executeQuery(query);
			
			ReportRecord rec = null;
			while (rs.next()) {
				rec = new ReportRecord();
				rec.setFixedRecord(new DimensionRecord(rs.getLong("f." + fixed.getIdName()), rs.getString(fixed.getInfoColumnName())));
				rec.setHorizontalRecord(new DimensionRecord(rs.getLong("h." + hDimDetails.getDimension().getIdName()), rs.getString(hDimDetails.getDimension().getInfoColumnName())));
				rec.setVerticalRecord(new DimensionRecord(rs.getLong("v." + vDimDetails.getDimension().getIdName()), rs.getString(vDimDetails.getDimension().getInfoColumnName())));
				rec.setFactRecord(new FactRecord(rs.getLong(fixed.getIdName()), rs.getLong(hDimDetails.getDimension().getIdName()), rs.getLong(vDimDetails.getDimension().getIdName()), rs.getString(fact.getInfoColumnName())));
				records.add(rec);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		return records;
	}
		
	
}
