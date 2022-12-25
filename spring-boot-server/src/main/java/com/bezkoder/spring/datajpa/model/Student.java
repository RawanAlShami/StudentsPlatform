package com.bezkoder.spring.datajpa.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentID;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "signed_in")
    private boolean signedIn;

    @JsonIgnore
    @ManyToMany(mappedBy="enrolledStudents")
    private Set<Course> registeredCourses = new HashSet<>();
    public Student() {}

    public Student(String userName, String password)
    {
        this.username=userName;
        this.password=password;
        this.signedIn=false;
    }

    public long getStudentID()
    { return studentID; }

    public void setStudentID(long studentID)
    { this.studentID = studentID; }

    public String getUsername()
    { return username; }

    public void setUsername(String username)
    { this.username = username; }

    public String getPassword()
    { return password; }

    public void setPassword(String password)
    { this.password = password; }

    public boolean isSignedIn()
    { return signedIn; }

    public void setSignedIn(boolean signedIn)
    { this.signedIn = signedIn; }

    public Set<Course> getRegisteredCourses()
    { return registeredCourses; }

    public void setRegisteredCourses(Set<Course> registeredCourses)
    { this.registeredCourses = registeredCourses; }
}
