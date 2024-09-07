package Application.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Application.model.BuildingDTO;
import Application.service.BuildingService;

@RestController
public class BuildingAPI {
	@Autowired
	private BuildingService buildingService;

	@GetMapping(value = "/api/building/")
	public List<BuildingDTO> getBuilding(@RequestParam(value="name", required = false) String name,
										@RequestParam(value="id", required = false) Integer id,
										@RequestParam(value="street", required = false) String street,
										@RequestParam(value="ward", required = false) String ward,
										@RequestParam(value="districtid", required = false) Integer districtid,
										@RequestParam(value="numberofbasement", required = false) Integer numberofbasement,
										@RequestParam(value="rentprice", required = false) Integer rentprice,
										@RequestParam(value="renttype", required = false) ArrayList<String> renttype,
										@RequestParam(value="rentarea", required = false) Integer rentarea) {
		List<BuildingDTO> buildings = buildingService.find(name, id, street, ward, districtid, numberofbasement, rentprice, renttype, rentarea);
		return buildings;
	}
	@PostMapping(value = "/api/test")
	public String OK() {
		return "ok";
	}
}
