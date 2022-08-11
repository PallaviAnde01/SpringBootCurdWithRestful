package com.PallaviAnde.Repository;

import java.util.List;

import com.PallaviAnde.Model.Emplyoee;

public interface EmplyoeeDao {

	public int saveData(Emplyoee emplyoee);
	public List<Emplyoee> getAllData();
}
