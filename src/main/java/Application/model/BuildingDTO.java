package Application.model;

import java.util.ArrayList;

public class BuildingDTO {
	private String name;
	private Integer numberOfBasement;
	private String street;
	private String ward;
	private Integer rentPrice;
	private String districtName;
	private ArrayList<String> renttype;
	private Integer rentArea;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}

	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public ArrayList<String> getRenttype() {
		return renttype;
	}

	public void setRenttype(ArrayList<String> renttype) {
		this.renttype = renttype;
	}

	public Integer getRentArea() {
		return rentArea;
	}

	public void setRentArea(Integer rentArea) {
		this.rentArea = rentArea;
	}

}
