package Application.repository.database;

import java.util.ArrayList;

public class SQLStatement {
	private String name, street, ward;
	private Integer id, districtid, numberofbasement, rentprice, rentarea;
	private ArrayList<String> renttype;
	
	public SQLStatement(String name, String street, String ward, Integer id, Integer districtid,
			Integer numberofbasement, Integer rentprice, Integer rentarea, ArrayList<String> renttype) {
		super();
		this.name = name;
		this.street = street;
		this.ward = ward;
		this.id = id;
		this.districtid = districtid;
		this.numberofbasement = numberofbasement;
		this.rentprice = rentprice;
		this.rentarea = rentarea;
		this.renttype = renttype;
	}
	
	public void joinDistrict(StringBuilder sql) {
		if(districtid != null) {
			sql.append("join district d on b.districtid = d.id ");
		}
		else {
			sql.append("left join district d on b.districtid = d.id ");
		}
	}
	
	public void joinRentType(StringBuilder sql) {
		if(renttype == null || renttype.isEmpty()) {
			sql.append("left join buildingrenttype brt on brt.buildingid = b.id ");
			sql.append("join renttype rt on brt.renttypeid = rt.id ");
		}
		else {
			sql.append("join buildingrenttype brt on brt.buildingid = b.id ");
			sql.append("join renttype rt on brt.renttypeid = rt.id ");
		}
	}
	
	public void joinRentArea(StringBuilder sql) {
		if(rentarea != null) {
			sql.append("join rentarea ra on b.id = ra.buildingid ");
		}
		else {
			sql.append("left join rentarea ra on b.id = ra.buildingid ");
		}
	}
	
	public void addWhereConditions(StringBuilder sql) {
		sql.append("where 1 = 1 ");
		if(id != null) {
			sql.append("and b.id = id ");
		}
		if(name != null && !name.equals("")) {
			sql.append("and b.name like '%" + name + "%' ");
		}
		if(ward != null && !ward.equals("")) {
			sql.append("and b.ward like '%" + ward + "%' ");
		}
		if(street != null && !street.equals("")) {
			sql.append("and b.street like '%" + street + "%' ");
		}
		if(districtid != null) {
			sql.append("and b.districtid = " + districtid + " ");
		}
		if(numberofbasement != null) {
			sql.append("and b.numberofbasement = " + numberofbasement + " ");
		}
		if(rentprice != null) {
			sql.append("and b.rentprice = " + rentprice + " ");
		}
		if(renttype != null) {
			sql.append("and rt.name in ('");
			for(int i = 0; i < renttype.size(); i++) {
				sql.append(renttype.get(i) + "'");
				if(i != renttype.size() - 1) {
					sql.append(", '");
				}
			}
			sql.append(") group by b.name having count(distinct rt.name) = " + renttype.size());
		}
		else 
			sql.append(" group by b.name ");
	}
	
	public String getSQLStatement() {
		StringBuilder sql = new StringBuilder("select b.*, d.name as district_name, "
				+ "group_concat(rt.name order by rt.name separator ', ') as renttype_name from building b ");
		joinDistrict(sql);
		joinRentType(sql);
		addWhereConditions(sql);
		return sql.toString();
	}
	
	public String getSQLStatementUpdateRentArea() {
		StringBuilder sql = new StringBuilder("select b.*, d.name as district_name, ra.value, "
				+ "group_concat(rt.name order by rt.name separator ', ') as renttype_name from building b ");
		joinDistrict(sql);
		joinRentArea(sql);
		joinRentType(sql);
		System.out.println("OK");
		addWhereConditions(sql);
		return sql.toString();
	}
}
