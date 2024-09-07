package Application.repository;

import java.util.ArrayList;
import java.util.List;

import Application.repository.entity.BuildingEntity;

public interface BuildingRepository {
	public List<BuildingEntity> find(String name, Integer id, String street, String ward, Integer districtid,
										Integer numberofbasement , Integer rentprice, ArrayList<String> renttype);
	public List<BuildingEntity> find(String name, Integer id, String street, String ward, Integer districtid,
			Integer numberofbasement , Integer rentprice, ArrayList<String> renttype, Integer rentarea);
	void deleteByID(Integer ID);
}
