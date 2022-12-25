package com.bezkoder.spring.datajpa.controller;
import com.bezkoder.spring.datajpa.model.Student;
import com.bezkoder.spring.datajpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class StudentController
{
    @Autowired
    StudentRepository studentRepository;

    @PostMapping(value = "/student/register")
    public String register(@RequestBody Student student)
    {
        studentRepository.save(student);
        return "Student Added Successfully";
    }

    @GetMapping(value="/students")
    public List<Student> viewStudents()
    { return studentRepository.findAll(); }

    @GetMapping("/student/{username}")
    public ResponseEntity<Student> getStudentID(@PathVariable("username") String username) {
        Student studentData = studentRepository.findByName(username);

        if (!studentData.equals(null)) {
            return new ResponseEntity<>(studentData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/student/signIn")
    public String signIn(@RequestBody Student student)
    {
        try
        {
            Student studentSignIn=studentRepository.findByName(student.getUsername());
            studentSignIn.setSignedIn(true);
            studentRepository.save(studentSignIn);
            return "Logged In Successfully";
        }
        catch (Exception e)
        {
            return "Failed To Login";
        }
    }
}