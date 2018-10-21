package vn.edu.saigontech.SpringMVCDemo.daos;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.NestedServletException;

import vn.edu.saigontech.SpringMVCDemo.models.Specialization;
import vn.edu.saigontech.SpringMVCDemo.models.customResponseEntity;
import vn.edu.saigontech.SpringMVCDemo.validators.SpecilizationValidator;

@Transactional
public class SpecializationDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public customResponseEntity getAllSpecialization() {
		customResponseEntity response = new customResponseEntity();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query<?> qry = session.createQuery("from Specialization");

			response.setErrorCode(0);
			response.setMessage("This is your list of specialization");
			response.setData(qry.list());

		} catch (Exception e) {
			response.setErrorCode(1);
			response.setMessage("Error of database");
			response.setData(e.getMessage());
		}

		return response;
	}

	public customResponseEntity getSpecializationByID(int id) {
		customResponseEntity response = new customResponseEntity();
		List<Specialization> targetSpec = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			Query<?> qry = session.createQuery("from Specialization s where s.ID = :id").setParameter("id", id);
			targetSpec = (List<Specialization>) qry.list();
			if (targetSpec.size() > 0) {
				response.setErrorCode(0);
				response.setMessage("This is your specialization with id equal " + id);
				response.setData(targetSpec.get(0));
			} else {
				response.setErrorCode(2);
				response.setMessage("This specialization is not exist");
				response.setData(null);
			}

		} catch (Exception e) {
			e.printStackTrace();
			response.setErrorCode(1);
			response.setMessage("Error of database");
			response.setData(null);
		}

		return response;
	}
	
	public customResponseEntity getSpecializationByName(String name) {
		customResponseEntity response = new customResponseEntity();
		List<Specialization> targetSpec = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			Query<?> qry = session.createQuery("from Specialization s where s.Name = :name").setParameter("name", name);
			targetSpec = (List<Specialization>) qry.list();
			if (targetSpec.size() > 0) {
				response.setErrorCode(0);
				response.setMessage("This is your specialization with id equal " + name);
				response.setData(targetSpec.get(0));
			} else {
				response.setErrorCode(2);
				response.setMessage("This specialization is not exist");
				response.setData(null);
			}

		} catch (Exception e) {
			e.printStackTrace();
			response.setErrorCode(1);
			response.setMessage("Error of database");
			response.setData(null);
		}

		return response;
	}

	public customResponseEntity addSpecialization(Specialization newSpecialization) {
		customResponseEntity response = new customResponseEntity();
		String validString = SpecilizationValidator.isValidForAdding(newSpecialization);
		System.out.println(validString);
		if (validString != "") {
			response.setErrorCode(3);
			response.setMessage(validString);
			response.setData(null);
			return response;
		}
		
		try {
			Session session = sessionFactory.getCurrentSession();
			session.persist(newSpecialization);
			response.setErrorCode(0);
			response.setMessage("Add this specialization successfully");
			response.setData(newSpecialization);

		} catch (Exception e) {
			response.setErrorCode(1);
			response.setMessage("Error of database");
			response.setData(e.getMessage());
		}

		return response;
	}

	public customResponseEntity deleteSpecialization(int id) {
		customResponseEntity response = new customResponseEntity();
		Specialization targetSpec = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			targetSpec = (Specialization) getSpecializationByID(id).getData();

			if (targetSpec != null) {
				session.delete(targetSpec);
				response.setErrorCode(0);
				response.setMessage("Delete this specialization successfully");
				response.setData(null);
			} else {
				response.setErrorCode(2);
				response.setMessage("This specialization is not exist");
				response.setData(null);
			}

		} catch (Exception e) {
			response.setErrorCode(1);
			response.setMessage("Error of database");
			response.setData(e.getMessage());
		}

		return response;
	}

	public customResponseEntity updateSpecialization(Specialization updateSpecialization) {
		customResponseEntity response = new customResponseEntity();
		
		String validString = SpecilizationValidator.isValidForUpdating(updateSpecialization);
		System.out.println(validString);
		if (validString != "") {
			response.setErrorCode(3);
			response.setMessage(validString);
			response.setData(null);
			return response;
		}
		
		try {
			Session session = sessionFactory.getCurrentSession();
			session.merge(updateSpecialization);
			response.setErrorCode(0);
			response.setMessage("Update this specialization successfully");
			response.setData(updateSpecialization);
		}
		 catch (Exception e) {
			response.setErrorCode(1);
			response.setMessage("Error of database");
			response.setData(e.getMessage());
		}

		return response;
	}

}
