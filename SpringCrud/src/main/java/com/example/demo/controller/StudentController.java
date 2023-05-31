package com.example.demo.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/studentapi")
public class StudentController {

	@Autowired
	private StudentService service;

	@PostMapping("/savestudent")
	public ResponseEntity<Student> addCustomer(@RequestBody Student st) {

		return new ResponseEntity<Student>(service.saveStudent(st), HttpStatus.CREATED);
	}

	@GetMapping("/list")
	public List<Student> getAllStudent() {
		return service.getAllStudents();
	}

	@GetMapping("/findbyname/sname")
	public ResponseEntity<List<Student>> getStudentByName(@RequestParam String sname) {
		return new ResponseEntity<List<Student>>(service.findByName(sname), HttpStatus.OK);
	}

	@GetMapping("find/{sid}")
	public ResponseEntity<Student> getCustomerById(@PathVariable("sid") long sid) {
		return new ResponseEntity<Student>(service.getStudentById(sid), HttpStatus.OK);
	}

	@PutMapping("update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student st) {
		return new ResponseEntity<Student>(service.updateStudent(st), HttpStatus.OK);
	}

	@DeleteMapping("delete/{sid}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("sid") long sid) {
		service.deleteStudentById(sid);
		return new ResponseEntity<String>("Deleted Successfully!", HttpStatus.OK);
	}

}
