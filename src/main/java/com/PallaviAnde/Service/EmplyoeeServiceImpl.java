package com.PallaviAnde.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.PallaviAnde.Model.Emplyoee;
import com.PallaviAnde.Repository.EmplyoeeDao;

@Service
public class EmplyoeeServiceImpl implements EmplyoeeService{
	@Autowired
	private EmplyoeeDao emplyoeeDao;

	@Override
	public int saveData(Emplyoee emplyoee) {
		int id = emplyoeeDao.saveData(emplyoee);
		return id;
	}

	@Override
	public List<Emplyoee> getAllData() {
		List<Emplyoee> allData = emplyoeeDao.getAllData();
		
		return allData;
	}

	@Override
	public Emplyoee updateData(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
