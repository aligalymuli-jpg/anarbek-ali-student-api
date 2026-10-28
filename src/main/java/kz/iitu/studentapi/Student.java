package kz.iitu.studentapi;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String studentGroup;
    private String studentIdNumber;
    private String email;

    public Student() {}

    public Student(String fullName, String studentGroup, String studentIdNumber, String email) {
        this.fullName = fullName;
        this.studentGroup = studentGroup;
        this.studentIdNumber = studentIdNumber;
        this.email = email;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getStudentGroup() { return studentGroup; }
    public void setStudentGroup(String studentGroup) { this.studentGroup = studentGroup; }
    public String getStudentIdNumber() { return studentIdNumber; }
    public void setStudentIdNumber(String studentIdNumber) { this.studentIdNumber = studentIdNumber; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
