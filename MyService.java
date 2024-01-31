package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

@Service
public class MyService {
	
	@Autowired
	MyRepository myrepo;
	
	public Student adding(Student student) {
		return myrepo.save(student);
	}
	
	
	public List<Student> fetching() {
		return (List<Student>) myrepo.findAll();
	}
	
	
	public ResponseEntity<?> deleting(int id) {
	if(myrepo.existsById(id)) {
		myrepo.deleteById(id);
		return new ResponseEntity<>("Deleted Successfully",HttpStatus.ACCEPTED);
	}else {
		return new ResponseEntity<>("Invalid Id",HttpStatus.BAD_REQUEST);
	}
	}
	
	public ResponseEntity<?> reading(int id) {
		if(myrepo.existsById(id)) {
		return new ResponseEntity<>(myrepo.findById(id),HttpStatus.OK);
		}else {
		return new ResponseEntity<>("Id Does not exist",HttpStatus.BAD_REQUEST);
		}

	}
	
	public ResponseEntity<?> updating(Student student,int id) {
		
		Student update = myrepo.findById(id).orElse(null);
		if(update!=null) {
			update.setName(student.getName());
			update.setDepartment(student.getDepartment());
			update.setAddress(student.getAddress());
			myrepo.save(update);
			return new ResponseEntity<>("Successfully updated",HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<>("Invalid Id",HttpStatus.BAD_REQUEST);
		}
		}
	
	

}
