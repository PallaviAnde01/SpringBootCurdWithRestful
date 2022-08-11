package com.PallaviAnde.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping(value="/update/{id}")
	public ResponseEntity<String> updateData(@PathVariable Integer id,@RequestBody Emplyoee emplyoee){
		 Emplyoee update = emplyoeeService.updateData(id);
		 if(update!=null) {
				update.setUsername(emplyoee.getUsername());
				update.setPassword(emplyoee.getPassword());
				update.setName(emplyoee.getName());
				update.setAddress(emplyoee.getAddress());
				update.setEmail(emplyoee.getEmail());
				update.setAge(emplyoee.getAge());
				update.setSalary(emplyoee.getSalary());
				int data = emplyoeeService.saveData(update);
				String msg="Id "+data+" updated successfully...";
				return new ResponseEntity<String>(msg,HttpStatus.OK);
			}else {
			return new ResponseEntity<String>("Such id is not present",HttpStatus.BAD_REQUEST);
			}
	}
	
	@DeleteMapping(value="/deletedata")
	public ResponseEntity<String> deleteData(){
		emplyoeeService.deleteData();
		return new ResponseEntity<String>("All data deleted",HttpStatus.OK);
		}
	
}
