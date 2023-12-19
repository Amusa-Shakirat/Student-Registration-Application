package com.example.Amusa.studentThymeleaf.service;


import com.example.Amusa.studentThymeleaf.exceptions.StudentNotFoundException;
import com.example.Amusa.studentThymeleaf.model.Student;
import com.example.Amusa.studentThymeleaf.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;


    @CacheEvict(value = "students", allEntries = true)
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }


    @Cacheable(value = "students")
    public List<Student> allStudent(){
        return studentRepository.findAll();
    }

    @Cacheable(value = "students", key = "#id")
    public Student getStudentById(Long id){
        return studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("Student with id: " + id + " can not be found"));
    }

    @CacheEvict(value = "students", key = "#id")
    public Student updateStudent(Long id, Student student){
        Student toUpdate = getStudentById(id);

        toUpdate.setAddress(student.getAddress());
        toUpdate.setEmail(student.getEmail());
        toUpdate.setLastName(student.getLastName());
        toUpdate.setFirstName(student.getFirstName());
        toUpdate.setPhoneNumber(student.getPhoneNumber());
        toUpdate.setDateOfBirth(student.getDateOfBirth());
        studentRepository.save(toUpdate);

        return studentRepository.save(toUpdate);
       // return saveStudent(toUpdate);
    }

    @CacheEvict(value = "students", allEntries = true)
    public String deleteStudent(Long id){
        Student toDelete = getStudentById(id);
        if ( toDelete == null){
            return "Student does not exist";
        }
        studentRepository.delete(toDelete);
        return "Student successfully deleted";
    }




}
