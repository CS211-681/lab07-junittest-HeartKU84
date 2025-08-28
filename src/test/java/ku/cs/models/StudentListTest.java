package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    static StudentList s;

    @BeforeEach()
    void setUp() {
        s = new StudentList();
        s.addNewStudent("6710450686", "Heart",99.9);
    }

    @Test
    @DisplayName("ทดสอบเพิ่มนักเรียน id=67xxxxxxxx name=Test ")
    void testAddNewStudent1() {
        s.addNewStudent("67xxxxxxxx", "Test");
        assertEquals(2,s.getStudents().size());
        assertEquals("Test",s.getStudents().get(1).getName());
        assertEquals("67xxxxxxxx",s.getStudents().get(1).getId());
    }

    @Test
    @DisplayName("ทดสอบเพิ่มนักเรียน id=67xxxxxxxx name=Test score=55.5")
    void testAddNewStudent2() {
        s.addNewStudent("67xxxxxxxx", "Test",55.5);
        assertEquals(2,s.getStudents().size());
        assertEquals("Test",s.getStudents().get(1).getName());
        assertEquals("67xxxxxxxx",s.getStudents().get(1).getId());
        assertEquals(55.5,s.getStudents().get(1).getScore());
    }

    @Test
    @DisplayName("ทดสอบค้นหานักเรียนจาก id=6710450686")
    void testFindStudentById() {
        assertEquals("Heart",s.findStudentById("6710450686").getName());
        assertEquals(99.9,s.findStudentById("6710450686").getScore());
    }

    @Test
    @DisplayName("ทดสอบค้นหาชื้อนักเรียนด้วย es")
    void testFilterByName() {
        s.addNewStudent("1xxxxxxxxx", "Test",90.0);
        s.addNewStudent("2xxxxxxxxx", "es",80.0);
        s.addNewStudent("3xxxxxxxxx", "Es",70.0);
        s.addNewStudent("4xxxxxxxxx", "abba",60.0);

        StudentList filtered;
        filtered = s.filterByName("es");
        assertEquals(3,filtered.getStudents().size());
        assertEquals("Test",filtered.getStudents().get(0).getName());
        assertEquals("es",filtered.getStudents().get(1).getName());
        assertEquals("Es",filtered.getStudents().get(2).getName());
        assertEquals("1xxxxxxxxx",filtered.getStudents().get(0).getId());
        assertEquals("2xxxxxxxxx",filtered.getStudents().get(1).getId());
        assertEquals("3xxxxxxxxx",filtered.getStudents().get(2).getId());
        assertEquals(90.0,filtered.getStudents().get(0).getScore());
        assertEquals(80.0,filtered.getStudents().get(1).getScore());
        assertEquals(70.0,filtered.getStudents().get(2).getScore());
    }

}