package Application.service;

import java.util.ArrayList;
import java.util.List;

import Application.model.BuildingDTO;

public interface BuildingService {
	// Phương thức này đã cũ và không còn giá trị sử dụng, vui lòng không sử dụng thành phần impl này
	List<BuildingDTO> find(String name, Integer id, String street, String ward, Integer districtid,
							Integer numberofbasement , Integer rentprice, ArrayList<String> renttype);
	List<BuildingDTO> find(String name, Integer id, String street, String ward, Integer districtid,
			Integer numberofbasement , Integer rentprice, ArrayList<String> renttype, Integer rentarea);
	void deleteByID(Integer id);
}
