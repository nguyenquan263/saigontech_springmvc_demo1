package vn.edu.saigontech.SpringMVCDemo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.mysql.jdbc.UpdatableResultSet;

import vn.edu.saigontech.SpringMVCDemo.daos.SpecializationDAO;
import vn.edu.saigontech.SpringMVCDemo.models.Specialization;

@Controller
@Transactional
@EnableWebMvc
public class SpecializationController {

	@Autowired
	private SpecializationDAO specializationDAO;

	@RequestMapping(value = "/Specialization")
	public ModelAndView getAllAdmin() {
		List<Specialization> specList = specializationDAO.getAllSpecialization();
		ModelAndView result = new ModelAndView("SpecializationList");

		result.addObject("listSpecialization", specList);
		return result;
	}

	@RequestMapping(value = "/addSpecialization")
	public ModelAndView goAdd() {
		ModelAndView result = new ModelAndView("addSpecialization");

		return result;
	}

	@RequestMapping(value = "/saveSpecialization")
	public String goSave(HttpServletRequest req) {
		String specName = "";
		Integer specCredit = -1;
		try {
			specName = req.getParameter("addName");
			specCredit = Integer.parseInt(req.getParameter("addCredit"));
		} catch (Exception e) {
			return "redirect:/Specialization?notification=Adding Unuccessfully!";
		}

		System.out.println(specName + " " + specCredit);

		Specialization newSpec = new Specialization(specName, specCredit);

		boolean res = specializationDAO.addSpecialization(newSpec);

		if (res == true)
			return "redirect:/Specialization?notification=Adding Successfully!";
		else
			return "redirect:/Specialization?notification=Adding Unuccessfully!";

	}

	@RequestMapping(value = "/deleteSpecialization")
	public String goDelete(@RequestParam("idDelete") String[] idDelete) {
		
		boolean temp = true;
		
		for (String id : idDelete)
			if (specializationDAO.getSpecializationByID(Integer.parseInt(id)) == null)
				return "redirect:/Specialization?notification=This specialization has been removed by another user";
		
		for (String id : idDelete) 
			specializationDAO.deleteSpecialization(Integer.parseInt(id));
		return "redirect:/Specialization?notification=Removing Successfully!";
	}

	@RequestMapping(value = "/updateSpecialization")
	public ModelAndView goUpdate(@RequestParam("idUpdate") String idUpdate) {

		ModelAndView mv = new ModelAndView("updateSpecialization");
		mv.addObject("targetSpec", specializationDAO.getSpecializationByID(Integer.parseInt(idUpdate)));

		return mv;
	}

	@RequestMapping(value = "/confirmUpdateSpecialization")
	public String goConfirmUpdate(HttpServletRequest req) {
		int updatedID = -1;
		String updatedName = "";
		int updatedCredit = -1;

		try {
			updatedID = Integer.parseInt(req.getParameter("updateID"));
			updatedName = req.getParameter("updateName");
			updatedCredit = Integer.parseInt(req.getParameter("updateCredit"));

		} catch (Exception e) {
			return "redirect:/Specialization?notification=Updating Unuccessfully!";
		}
		
		Specialization targetSpec = new Specialization(updatedID, updatedName, updatedCredit);

		boolean res = specializationDAO.updateSpecialization(targetSpec);

		if (res == true)
			return "redirect:/Specialization?notification=Updating Successfully!";
		else
			return "redirect:/Specialization?notification=Updating Unuccessfully!";

	}
}
