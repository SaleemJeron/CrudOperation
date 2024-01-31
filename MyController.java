package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crud")
public class MyController {
	@Autowired
	MyService service;
	
	@PostMapping("/add")
	public Student add(@RequestBody Student student) {
		return service.adding(student);
	}
	
	@GetMapping("/fetch")
	public List<Student> fetch() {
	return service.fetching();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		return service.deleting(id);
	}
	
	@GetMapping("/read/{id}")
	public ResponseEntity<?> read(@PathVariable int id) {
	return service.reading(id);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody Student student, @PathVariable int id) {
		return service.updating(student, id);
	}

}
