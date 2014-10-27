package dao;

import model.Fact;
import model.Report;
import model.dimension.Dimension;
import model.dimension.FixedDimension;
import model.dimension.OrientedDimension;
import model.record.DimensionRecord;
import model.record.ReportRecord;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApplestoreDAO {

    private static final String databaseUrl = "jdbc:sqlite:C:/temp/applestore.db";

	public List<DimensionRecord> getDimensionValues(Dimension dim) {
		
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
	
	public List<ReportRecord> getReportRecords(Report report) {
		
		Connection conn = null;
		Statement stmt = null;
		
		List<ReportRecord> values = new ArrayList<ReportRecord>();
		
		try {
			Class.forName("org.sqlite.JDBC");

            conn = DriverManager.getConnection(databaseUrl);
			
			FixedDimension fixed = report.getFixedDimension();
			OrientedDimension hDim = report.getHorizontalDimensionDetails().getDimension();
			OrientedDimension vDim = report.getVerticalDimensionDetails().getDimension();
			Fact fact = report.getFact();
			
			stmt = conn.createStatement();
			String query = "SELECT * FROM " + fact.getName() + " fact " 
						+ "join " + fixed.getName() + " f on fact." + fact.getFixedDimensionKey()  + "=f." + fixed.getIdName()
						+ " join " + hDim.getName() + " h on fact." + fact.getHorizontalDimensionKey() + "=h." + hDim.getIdName()
						+ " join " + vDim.getName() + " v on fact." + fact.getVerticalDimensionKey() + "=v." + vDim.getIdName()
						+ " where f." + fixed.getInfoColumnName() + "=\"" + fixed.getFixedValue() + "\";";
			System.out.println(query);
			ResultSet rs = stmt.executeQuery(query);
			
			ReportRecord rec = null;
			while (rs.next()) {
				rec = new ReportRecord();
				rec.setFixedRecord(new DimensionRecord(rs.getLong(fact.getFixedDimensionKey()), rs.getString(fixed.getInfoColumnName())));
				rec.setHorizontalRecord(new DimensionRecord(rs.getLong(fact.getHorizontalDimensionKey()), rs.getString(hDim.getInfoColumnName())));
				rec.setVerticalRecord(new DimensionRecord(rs.getLong(fact.getVerticalDimensionKey()), rs.getString(vDim.getInfoColumnName())));
				//rec.setFact;
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
		
		
		return null;
	}
		
	
}
