package com.PallaviAnde.Service;

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

}
