package com.PallaviAnde.Repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.PallaviAnde.Model.Emplyoee;

@Repository
public class EmplyoeeDaoImpl implements EmplyoeeDao{

	@Autowired
	private SessionFactory sf;
	
	@Override
	public int saveData(Emplyoee emplyoee) {
		Session session = sf.openSession();
		session.beginTransaction();
		 int id = (int) session.save(emplyoee);
		session.getTransaction().commit();
		
		return id;
	}

	@Override
	public List<Emplyoee> getAllData() {
		String hql="from Emplyoee";
		Session session = sf.openSession();
		Query query = session.createQuery(hql);
		List list = query.getResultList();
		
		return list;
	}

	@Override
	public Emplyoee updateData(Integer id) {
		Session session = sf.openSession();
		Emplyoee emplyoee = session.get(Emplyoee.class, id);
		if(emplyoee!=null) {
			return emplyoee;
		}else {
		return null;
		}
	}

}
