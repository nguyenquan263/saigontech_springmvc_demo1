package vn.edu.saigontech.SpringMVCDemo.daos;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import vn.edu.saigontech.SpringMVCDemo.models.Specialization;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class SpecializationDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Specialization> getAllSpecialization() {

		Session session = sessionFactory.getCurrentSession();

		Query qry = session.createQuery("from Specialization");

		return qry.list();

	}

	public Specialization getSpecializationByID(int id) {
		Session session = sessionFactory.getCurrentSession();
		Specialization target = null;
		try {
			target = (Specialization) session.createQuery("from Specialization s where s.ID =" + id).list().get(0);
		} catch (Exception e) {}
		return target;
	}

	public boolean addSpecialization(Specialization newSpec) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(newSpec);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteSpecialization(int deleteID) {
		Specialization spec = this.getSpecializationByID(deleteID);
		if (spec != null) {
			this.sessionFactory.getCurrentSession().delete(spec);
			return true;
		}

		return false;
	}

	public boolean updateSpecialization(Specialization spec) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.update(spec);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
