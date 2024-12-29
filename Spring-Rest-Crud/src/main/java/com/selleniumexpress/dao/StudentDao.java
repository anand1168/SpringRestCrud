package com.selleniumexpress.dao;

import java.util.List;

import com.selleniumexpress.api.Student;

public interface StudentDao {
	
	
	public List<Student> getStudents();
	public Student findByID(int id);
	public Student save(Student st);
	public Student  modify(Student st,int id);
	public String delete(int id);
	

}
