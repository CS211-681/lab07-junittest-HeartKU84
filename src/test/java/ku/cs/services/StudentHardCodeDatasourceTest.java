package ku.cs.services;

import ku.cs.models.StudentList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {
    StudentHardCodeDatasource datasource = new StudentHardCodeDatasource();
    StudentList list = datasource.readData();

    @Test
    void test() {

    }
}