package com.PallaviAnde.Repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

}
