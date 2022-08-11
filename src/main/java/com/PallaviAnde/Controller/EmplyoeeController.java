package com.PallaviAnde.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PallaviAnde.Model.Emplyoee;
import com.PallaviAnde.Service.EmplyoeeService;

@RestController
public class EmplyoeeController {

	@Autowired
	private EmplyoeeService emplyoeeService;
	
	@PostMapping(value="/savedata",consumes="application/json")
	public ResponseEntity<String> saveData(@RequestBody Emplyoee emplyoee) {
		int data = emplyoeeService.saveData(emplyoee);
		String msg="Hii "+emplyoee.getName()+" your id is "+data;
		
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}
	
	@GetMapping(value="/getdata",produces="application/json")
	public ResponseEntity<List<Emplyoee>> getAllData(){
		List<Emplyoee> allData = emplyoeeService.getAllData();
		
		return new ResponseEntity<List<Emplyoee>>(allData,HttpStatus.OK);
		}
	
	
}
