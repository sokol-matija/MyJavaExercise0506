package hr.algebra.dal;

import hr.algebra.model.Student;
import java.util.List;

public interface Repository {

    int createStudent(Student student) throws Exception;

    void updateStudent(int id, Student data) throws Exception;

    void deleteStudent(int id) throws Exception;

    Student selectStudent(int id) throws Exception;

    List<Student> selectStudents() throws Exception;

}
