package com.selleniumexpress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.selleniumexpress.api.Student;
import com.selleniumexpress.dao.StudentDao;

@RestController
public class StudentController {
	
	@Autowired
	private StudentDao studentDao;
	
	
	@GetMapping(value="/students", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<Student>> getAllStudent(){
		
		
		List<Student> students = studentDao.getStudents();
		
		return ResponseEntity.ok(students);
		
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable("id") int studentId){
		
		Student student = studentDao.findByID(studentId);
		
		return new ResponseEntity<Student>(student,HttpStatus.OK);
		
		
	}
	

}
