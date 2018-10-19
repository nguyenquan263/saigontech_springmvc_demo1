package vn.edu.saigontech.SpringMVCDemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.edu.saigontech.SpringMVCDemo.daos.SpecializationDAO;
import vn.edu.saigontech.SpringMVCDemo.models.customeResponseEntity;
import vn.edu.saigontech.SpringMVCDemo.models.Specialization;

@RestController
public class SpecializationRESTController {
	
	@Autowired
	private SpecializationDAO specializationDAO;
	
	@RequestMapping(value = "/SpecializationREST", method = RequestMethod.GET)
	public customeResponseEntity getAllSpec() {
		
		customeResponseEntity rE = new customeResponseEntity(0, "Specializations has been loaded!", specializationDAO.getAllSpecialization());
		
		return rE;
	}
	
	@RequestMapping(value = "/SpecializationREST/{id}", method = RequestMethod.GET)
	public customeResponseEntity getSpecByID(@PathVariable("id") int id) {
		customeResponseEntity rE = new customeResponseEntity(0, "This specialization has been loaded!", specializationDAO.getSpecializationByID(id));
		
		return rE;
	}
	
	@RequestMapping(value = "/SpecializationREST", method = RequestMethod.POST)
	public customeResponseEntity addSpec(@RequestBody Specialization spec) {
		
		customeResponseEntity rE = new customeResponseEntity(0, "Add this specialization successfully", specializationDAO.addSpecialization(spec));
		
		return rE;
	}
	
	@RequestMapping(value = "/SpecializationREST", method = RequestMethod.PUT)
	public customeResponseEntity updateSpec(@RequestBody Specialization spec) {
		customeResponseEntity rE = new customeResponseEntity(0, "Update this specialization successfully", specializationDAO.updateSpecialization(spec));
		return rE;
	}
	
	@RequestMapping(value = "/SpecializationREST/{id}", method = RequestMethod.DELETE)
	public customeResponseEntity deleteSpec(@PathVariable("id") int id) {
		customeResponseEntity rE = new customeResponseEntity(0, "Delete this specialization successfully", specializationDAO.deleteSpecialization(id));
		return rE;
	}
	
	
	
	
	
	
	
	

}
