package com.bezkoder.spring.datajpa.model;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long courseID;

    @Column(name = "name")
    private String courseName;

    @ManyToMany
    @JoinTable(
            name="studentsEnrolled",
            joinColumns=@JoinColumn(name="courseId"),
            inverseJoinColumns = @JoinColumn(name="studentId")
    )
    private Set<Student> enrolledStudents = new HashSet<>();

    public Course() {}

    public Course(String courseName)
    {
        this.courseName=courseName;
    }

    public void enrollStudent(Student student)
    { enrolledStudents.add(student); }

    public long getCourseID()
    {   return courseID;    }

    public void setCourseID(long courseID)
    {   this.courseID = courseID;   }

    public String getCourseName()
    {   return courseName;  }

    public void setCourseName(String courseName)
    {   this.courseName = courseName;   }

    public Set<Student> getEnrolledStudents()
    { return enrolledStudents; }
}
