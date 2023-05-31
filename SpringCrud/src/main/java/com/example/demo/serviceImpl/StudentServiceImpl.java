package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo repo;

	@Override
	public List<Student> getAllStudents() {

		return repo.findAll();
	}

	@Override
	public Student saveStudent(Student student) {

		return repo.save(student);
	}

	@Override
	public Student getStudentById(Long id) {

		return repo.findById(id).orElse(null);
	}

	@Override
	public Student updateStudent(Student student) {

		Student st = repo.findById(student.getId()).orElse(null);
		st.setName(student.getName());
		st.setEmail(student.getEmail());
		st.setUserName(student.getUserName());
		st.setPassword(student.getPassword());
		return repo.save(st);
	}

	@Override
	public String deleteStudentById(Long id) {
		Student existsID = repo.findById(id).orElse(null);
		if (existsID != null) {
			repo.deleteById(id);
			return " Student deleted!!";
		} else {
			return "Student does not exists!!";
		}

	}

	@Override
	public List<Student> findByName(String Name) {

		return repo.findByName(Name);
	}

}
