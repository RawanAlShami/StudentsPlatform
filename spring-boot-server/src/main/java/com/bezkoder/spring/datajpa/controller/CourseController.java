package com.bezkoder.spring.datajpa.controller;

import java.util.List;
import com.bezkoder.spring.datajpa.model.Course;
import com.bezkoder.spring.datajpa.model.Student;
import com.bezkoder.spring.datajpa.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.bezkoder.spring.datajpa.repository.CourseRepository;

@RestController
@CrossOrigin
public class CourseController
{
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    StudentRepository studentRepository;

    @PostMapping(value = "/course")
    public String addCourse(@RequestBody Course course)
    {
        courseRepository.save(course);
        return "Course Added Successfully";
    }

    @GetMapping(value="/courses")
    public List<Course> viewCourses()
    { return courseRepository.findAll(); }

    @PutMapping(value="/{courseId}/students/{studentId}")
    public Course enrollStudent(@PathVariable Long courseId, @PathVariable Long studentId)
    {
        Course course=courseRepository.findById(courseId).get();
        Student student=studentRepository.findById(studentId).get();
        course.enrollStudent(student);
        return courseRepository.save(course);
    }
}