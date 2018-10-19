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
import vn.edu.saigontech.SpringMVCDemo.models.customResponseEntity;
import vn.edu.saigontech.SpringMVCDemo.models.Specialization;

@RestController
public class SpecializationRESTController {
	
	@Autowired
	private SpecializationDAO specializationDAO;
	
	@RequestMapping(value = "/SpecializationREST", method = RequestMethod.GET)
	public customResponseEntity getAllSpec() {
		
		List<Specialization> res = specializationDAO.getAllSpecialization();
		customResponseEntity rE;
		if (res == null)
			rE = new customResponseEntity(1, "Specializations has not been loaded!", null);
		else 
			rE = new customResponseEntity(0, "Specializations has been loaded!", specializationDAO.getAllSpecialization());
		
		return rE;
	}
	
	@RequestMapping(value = "/SpecializationREST/{id}", method = RequestMethod.GET)
	public customResponseEntity getSpecByID(@PathVariable("id") int id) {
		
		Specialization res = specializationDAO.getSpecializationByID(id);
		customResponseEntity rE;
		if (res == null)
			rE = new customResponseEntity(1, "This specialization has not been loaded!", null);
		else 
			rE = new customResponseEntity(0, "This specialization has been loaded!", specializationDAO.getSpecializationByID(id));
		
		return rE;
	}
	
	@RequestMapping(value = "/SpecializationREST", method = RequestMethod.POST)
	public customResponseEntity addSpec(@RequestBody Specialization spec) {
		
		boolean res = specializationDAO.addSpecialization(spec);
		customResponseEntity rE;
		if (res == true)
			rE = new customResponseEntity(0, "Add this specialization successfully", true);
		else 
			rE = new customResponseEntity(1, "Add this specialization unsuccessfully", false);
		return rE;
	}
	
	@RequestMapping(value = "/SpecializationREST", method = RequestMethod.PUT)
	public customResponseEntity updateSpec(@RequestBody Specialization spec) {
		boolean res = specializationDAO.updateSpecialization(spec);
		customResponseEntity rE;
		if (res == true)
			rE = new customResponseEntity(0, "Update this specialization successfully", true);
		else 
			rE = new customResponseEntity(1, "Update this specialization unsuccessfully", false);
		return rE;
	}
	
	@RequestMapping(value = "/SpecializationREST/{id}", method = RequestMethod.DELETE)
	public customResponseEntity deleteSpec(@PathVariable("id") int id) {
		boolean res = specializationDAO.deleteSpecialization(id);
		customResponseEntity rE;
		if (res == true)
			rE = new customResponseEntity(0, "Delete this specialization successfully", true);
		else 
			rE = new customResponseEntity(1, "Delete this specialization unsuccessfully", false);
		return rE;
	}
	
	
	
	
	
	
	
	

}
