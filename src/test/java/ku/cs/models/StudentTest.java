package ku.cs.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    static Student student;

    @BeforeEach
    void setUp() {
        student = new Student("6710450686", "test");
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 55.5 คะแนน")
    void testAddScore1() {
        student.addScore(55.5);
        assertEquals(55.5, student.getScore()); // passed
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 80 คะแนน")
    void testAddScore2() {
        student.addScore(80);
        assertEquals(80, student.getScore()); // passed
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน -40.5 คะแนน")
    void testAddScore3() {
        double beforeAddScore = student.getScore();
        student.addScore(-40.5);
        assertEquals(beforeAddScore, student.getScore()); // passed
    }

    @Test
    @DisplayName("ทดสอบการคำนวนเกรด 80.0 คะแนน")
    void testCalculateGrade1() {
        student.addScore(80.0);
        assertEquals("A",student.getGrade()); // passed
    }

    @Test
    @DisplayName("ทดสอบการคำนวนเกรด 70.0 คะแนน")
    void testCalculateGrade2() {
        student.addScore(70.0);
        assertEquals("B",student.getGrade()); // passed
    }

    @Test
    @DisplayName("ทดสอบการคำนวนเกรด 60.0 คะแนน")
    void testCalculateGrade3() {
        student.addScore(60.0);
        assertEquals("C",student.getGrade()); // passed
    }

    @Test
    @DisplayName("ทดสอบการคำนวนเกรด 50.0 คะแนน")
    void testCalculateGrade4() {
        student.addScore(50.0);
        assertEquals("D",student.getGrade()); // passed
    }

    @Test
    @DisplayName("ทดสอบการคำนวนเกรด 30.0 คะแนน")
    void testCalculateGrade5() {
        student.addScore(30.0);
        assertEquals("F",student.getGrade()); // passed
    }

    @Test
    @DisplayName("ทดสอบเปลี่ยนชื่อจาก test เป็น Heart")
    void testChangeName() {
        student.changeName("Heart");
        assertEquals("Heart",student.getName());
    }

    @Test
    @DisplayName("ทดสอบการค้นหา ear ใน Heart")
    void testIsNameContains1() {
        Student test = new Student("6710450686","Heart");
        assertTrue(test.isNameContains("ear"));
    }

    @Test
    @DisplayName("ทดสอบการค้นหา ear ใน traeH")
    void testIsNameContains2() {
        Student test = new Student("6710450686","traeH");
        assertFalse(test.isNameContains("ear"));
    }

    @Test
    @DisplayName("ทดสอบเช็ค id 6710450686")
    void testisId1() {
        assertTrue(student.isId("6710450686"));
    }

    @Test
    @DisplayName("ทดสอบเช็ค id 6710450999")
    void testisId2() {
        assertFalse(student.isId("6710450999"));
    }
}