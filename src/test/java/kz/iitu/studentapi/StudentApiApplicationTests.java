package kz.iitu.studentapi;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentApiApplicationTests {
    @Test
    void verifyStudentIdentity() {
        Student student = new Student("Anarbek Ali", "IT2308", "41505", "ali.anarbek@iitu.edu.kz");
        assertEquals("Anarbek Ali", student.getFullName());
        assertEquals("IT2308", student.getStudentGroup());
        assertEquals("41505", student.getStudentIdNumber());
    }
}
