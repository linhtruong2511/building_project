package Application.repository.entity;

import java.util.ArrayList;

public class BuildingEntity {
	private String name;
	private String street;
	private Integer numberOfBaseMent;
	private String ward;
	private Integer districtID;
	private String nameDistrict;
	private Integer rentPrice;
	private ArrayList<String> rentType;
	private Integer rentArea;

	public Integer getRentArea() {
		return rentArea;
	}

	public void setRentArea(Integer rentArea) {
		this.rentArea = rentArea;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getNumberOfBaseMent() {
		return numberOfBaseMent;
	}

	public void setNumberOfBaseMent(Integer numberOfBaseMent) {
		this.numberOfBaseMent = numberOfBaseMent;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public Integer getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(Integer rentPrice) {
		this.rentPrice = rentPrice;
	}

	public Integer getDistrictID() {
		return districtID;
	}

	public void setDistrictID(Integer districtID) {
		this.districtID = districtID;
	}

	public String getNameDistrict() {
		return nameDistrict;
	}

	public void setNameDistrict(String nameDistrict) {
		this.nameDistrict = nameDistrict;
	}

	public ArrayList<String> getRentType() {
		return rentType;
	}

	public void setRentType(ArrayList<String> rentType) {
		this.rentType = rentType;
	}

}
