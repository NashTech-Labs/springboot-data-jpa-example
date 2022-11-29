package com.knoldus.springdatajpa.repository;

import com.knoldus.springdatajpa.entity.Parents;
import com.knoldus.springdatajpa.entity.Student;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("adm123@gmail.com")
                .firstName("Adam")
                .lastName("Seekar")
                //.guardianEmail("jk123@gmail.com")
                //.guardianName("JK")
                //.guardianMobile("8989898989")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Parents parents = Parents.builder()
                .email("jk123@gmail.com")
                .name("JK")
                .mobile("8989898989")
                .build();
        Student student = Student.builder()
                .firstName("Sonu")
                .lastName("sharma")
                .emailId("sharma11@gmail.com")
                .parents(parents)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList =
        studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }
    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository
                .findByFirstName("Sonu");
        System.out.println("students = " + students);
    }
    @Test
    public void printStudentByEmailAddress(){
        Student student = studentRepository
                .getStudentByEmailAddress("sharma11@gmail.com");
        System.out.println("student = " + student);
    }
    @Test
    public void printStudentFirstNameByEmailAddress(){
        String firstName = studentRepository
                .getStudentFirstNameByEmailAddress("adm123@gmail.com");
        System.out.println("firstName = " + firstName);
    }

}