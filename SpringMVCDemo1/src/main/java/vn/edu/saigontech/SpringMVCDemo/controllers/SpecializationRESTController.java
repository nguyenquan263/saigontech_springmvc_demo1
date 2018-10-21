package vn.edu.saigontech.SpringMVCDemo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import vn.edu.saigontech.SpringMVCDemo.daos.SpecializationDAO;
import vn.edu.saigontech.SpringMVCDemo.models.Specialization;
import vn.edu.saigontech.SpringMVCDemo.models.customResponseEntity;

@RestController
public class SpecializationRESTController {
	@Autowired
	private SpecializationDAO specializationDAO;
	
	@RequestMapping(value = "/SpecializationREST", method = RequestMethod.GET)
	public customResponseEntity getAllSpecialization() {
		return specializationDAO.getAllSpecialization();
	}
	
	@RequestMapping(value = "/SpecializationREST/{id}", method = RequestMethod.GET)
	public customResponseEntity getAllSpecialization(@PathVariable int id) {
		return specializationDAO.getSpecializationByID(id);
	}
	
	@RequestMapping(value = "/SpecializationREST", method = RequestMethod.POST)
	public customResponseEntity getAllSpecialization(@RequestBody Specialization newSpec) {
		return specializationDAO.addSpecialization(newSpec);
	}
	
	@RequestMapping(value = "/SpecializationREST/{id}", method = RequestMethod.DELETE)
	public customResponseEntity deleteSpecialization(@PathVariable int id) {
		return specializationDAO.deleteSpecialization(id);
	}
	
	@RequestMapping(value = "/SpecializationREST", method = RequestMethod.PUT)
	public customResponseEntity updateSpecialization(@RequestBody Specialization updateSpec) {
		return specializationDAO.updateSpecialization(updateSpec);
	}
	
	
	
	

}
