package com.selleniumexpress.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.selleniumexpress.api.Student;

@Component
public class StudnetDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Student> getStudents() {

		String sql = "SELECT * FROM STUDENT";

		List<Student> list = jdbcTemplate.query(sql, rs -> {

			List<Student> st = new ArrayList<>();
			while (rs.next()) {

				Student ss = new Student();

				ss.setRollNo(rs.getInt(1));
				ss.setStudentName(rs.getString(2));
				ss.setAddress(rs.getString(3));
				st.add(ss);
			}
			return st;
		});

		return list;
	}

	@Override
	public Student findByID(int id) {
		
		String sql="SELECT * FROM STUDENT WHERE rollNo=?";
		
		Object[] arr= {id};
		 List<Student> list = jdbcTemplate.query(sql, rs -> {

			List<Student> st = new ArrayList<>();
			while (rs.next()) {

				Student ss = new Student();

				ss.setRollNo(rs.getInt(1));
				ss.setStudentName(rs.getString(2));
				ss.setAddress(rs.getString(3));
				st.add(ss);
			}
			return st;
		}, arr);
			
			
			
			
		
		
		return list.get(0);
	}

	@Override
	public Student save(Student st) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student modify(Student st, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
