package vn.edu.saigontech.SpringMVCDemo.validators;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import vn.edu.saigontech.SpringMVCDemo.daos.SpecializationDAO;
import vn.edu.saigontech.SpringMVCDemo.models.Specialization;
import vn.edu.saigontech.SpringMVCDemo.models.customResponseEntity;

@Transactional
public class SpecilizationValidator {
	@Autowired
	private SpecializationDAO specializationDAO;
	
	public static String isValidForAdding(Specialization spec) {
		String name = spec.getName();
		if (name == "" || name == null)
			return "Please fill specialization name";
		int numberCredit = spec.getNumberCredit();
		if (Double.isNaN(numberCredit) || numberCredit < 1)
			return "Please fill number of credit";
		
		return "";
	}
	
	public static String isValidForUpdating(Specialization spec) {
		int id = spec.getID();
		if (Double.isNaN(id) || id < 1)
			return "Please fill id";
		
		String name = spec.getName();
		if (name == "" || name == null)
			return "Please fill name";
		int numberCredit = spec.getNumberCredit();
		if (Double.isNaN(numberCredit) || numberCredit < 1)
			return "Please fill number of credit";
		
		return "";
	}
	


}
