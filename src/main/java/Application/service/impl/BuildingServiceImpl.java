package Application.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Application.model.BuildingDTO;
import Application.repository.BuildingRepository;
import Application.repository.entity.BuildingEntity;
import Application.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	private BuildingRepository buildingRepository;

	@Override
	public void deleteByID(Integer id) {
	}

	@Override
	public List<BuildingDTO> find(String name, Integer id, String street, String ward, Integer districtid,
			Integer numberofbasement, Integer rentprice, ArrayList<String> renttype) {
		List<BuildingEntity> buildingEntities = buildingRepository.find(name, id, street, ward, districtid, numberofbasement, rentprice, renttype);
		List<BuildingDTO> result = new ArrayList<BuildingDTO>();
		for(BuildingEntity item : buildingEntities) {
			BuildingDTO temp = new BuildingDTO();
			temp.setName(item.getName());
			temp.setNumberOfBasement(item.getNumberOfBaseMent());
			temp.setStreet(item.getStreet());
			temp.setRentPrice(item.getRentPrice());
			temp.setWard(item.getWard());
			temp.setDistrictName(item.getNameDistrict());
			temp.setRenttype(item.getRentType());
			result.add(temp);
		}
		return result;
	}

	@Override
	public List<BuildingDTO> find(String name, Integer id, String street, String ward, Integer districtid,
			Integer numberofbasement, Integer rentprice, ArrayList<String> renttype, Integer rentarea) {
		List<BuildingEntity> buildingEntities = buildingRepository.find(name, id, street, ward, districtid, numberofbasement, rentprice, renttype, rentarea);
		List<BuildingDTO> result = new ArrayList<BuildingDTO>();
		for(BuildingEntity item : buildingEntities) {
			BuildingDTO temp = new BuildingDTO();
			temp.setName(item.getName());
			temp.setNumberOfBasement(item.getNumberOfBaseMent());
			temp.setStreet(item.getStreet());
			temp.setRentPrice(item.getRentPrice());
			temp.setWard(item.getWard());
			temp.setDistrictName(item.getNameDistrict());
			temp.setRenttype(item.getRentType());
			temp.setRentArea(item.getRentArea());
			result.add(temp);
		}
		return result;
	}

}
