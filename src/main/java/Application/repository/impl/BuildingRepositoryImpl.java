package Application.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Repository;

import Application.repository.BuildingRepository;
import Application.repository.database.SQLStatement;
import Application.repository.entity.BuildingEntity;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
	static final String URL = "jdbc:mysql://localhost:3306/estatebasic";
	static final String NAME = "root";
	static final String PASS = "";

	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, NAME, PASS);
		} catch (SQLException e) {
			e.getMessage();
		}
		return con;
	}

	@Override
	public void deleteByID(Integer ID) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public List<BuildingEntity> find(String name, Integer id, String street, String ward, Integer districtid,
			Integer numberofbasement, Integer rentprice, ArrayList<String> renttype) {
		List<BuildingEntity> list = new ArrayList<BuildingEntity>();
		SQLStatement sqlStatement = new SQLStatement(name, street, ward, id, districtid, numberofbasement, 
														rentprice, null, renttype);
		StringBuilder sql = new StringBuilder(sqlStatement.getSQLStatement());
		Connection con = getConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet res = stm.executeQuery(sql.toString());
			while(res.next()) {
				BuildingEntity building = new BuildingEntity();
				building.setName(res.getString("name"));
				building.setStreet(res.getString("street"));
				building.setNumberOfBaseMent(res.getInt("numberofbasement"));
				building.setWard(res.getString("ward"));
				building.setDistrictID(res.getInt("districtid"));
				building.setRentPrice(res.getInt("rentprice"));
				building.setNameDistrict(res.getString("district_name"));
				building.setRentType(toArrayList(res.getString("renttype_name")));
				list.add(building);
			}
			return list;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	@Override
	public List<BuildingEntity> find(String name, Integer id, String street, String ward, Integer districtid,
			Integer numberofbasement, Integer rentprice, ArrayList<String> renttype, Integer rentarea) {
		List<BuildingEntity> list = new ArrayList<BuildingEntity>();
		SQLStatement sqlStatement = new SQLStatement(name, street, ward, id, districtid, numberofbasement, 
														rentprice, rentarea, renttype);
		StringBuilder sql = new StringBuilder(sqlStatement.getSQLStatementUpdateRentArea());
		Connection con = getConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet res = stm.executeQuery(sql.toString());
			while(res.next()) {
				BuildingEntity building = new BuildingEntity();
				building.setName(res.getString("name"));
				building.setStreet(res.getString("street"));
				building.setNumberOfBaseMent(res.getInt("numberofbasement"));
				building.setWard(res.getString("ward"));
				building.setDistrictID(res.getInt("districtid"));
				building.setRentPrice(res.getInt("rentprice"));
				building.setNameDistrict(res.getString("district_name"));
				building.setRentType(toArrayList(res.getString("renttype_name")));
				building.setRentArea(res.getInt("value"));
				list.add(building);
			}
			return list;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	ArrayList<String> toArrayList(String rentTypeNameString) {
		String[] renttypeNames = rentTypeNameString.split(", ");
		HashSet<String> setRentTypeName = new HashSet<String>();
		for (String rtn : renttypeNames) {
			setRentTypeName.add(rtn);
		}
		ArrayList<String> listRentTypeName = new ArrayList<String>();
		for(String emp : setRentTypeName) {
			listRentTypeName.add(emp);
		}
		return listRentTypeName;
	}
}
