/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal;

import hr.algebra.model.Student;
import java.util.List;

/**
 *
 * @author dnlbe
 */
public interface Repository {
    
    int createStudent(Student student) throws Exception;
    void updateStudent(int id, Student data) throws Exception;
    void deleteStudent(int id) throws Exception;
    Student selectStudent(int id) throws Exception;
    List<Student> selectStudents() throws Exception;
}
