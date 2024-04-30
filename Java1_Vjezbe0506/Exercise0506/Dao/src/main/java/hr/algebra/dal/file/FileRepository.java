/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal.file;

import hr.algebra.dal.Repository;
import hr.algebra.model.Student;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

/**
 *
 * @author dnlbe
 */
public class FileRepository implements Repository{

    private static final String DIR = "files";
    private static final Path DIR_PATH = Paths.get(DIR);
    private static final Path STUDENTS_PATH = Paths.get(DIR + File.separator + "students.txt");

    public FileRepository() throws IOException {
        if(!Files.exists(STUDENTS_PATH)) {
            Files.createDirectories(DIR_PATH);
            Files.createFile(STUDENTS_PATH);
        }
    }

    @Override
    public int createStudent(Student student) throws Exception {
        int maxId = 0;
        OptionalInt max = selectStudents()
                .stream()
                .mapToInt(s->s.getId())
                .max();
        if (max.isPresent()) {
            maxId = max.getAsInt();
        }
        student.setId(++maxId);
        Files.write(STUDENTS_PATH, student.formatForFileLine().getBytes(), StandardOpenOption.APPEND);
        return maxId;
    }

    @Override
    public void updateStudent(int id, Student data) throws Exception {
        List<Student> students = selectStudents();
        Optional<Student> optStudent = students
                .stream()
                .filter(s -> s.getId() == id)
                .findFirst();
        if (optStudent.isPresent()) {
            Student student = optStudent.get();
            student.setFirstName(data.getFirstName());
            student.setLastName(data.getLastName());
            student.setGrade(data.getGrade());
            student.setPicturePath(data.getPicturePath());
            writeStudents(students);
        }
    }

    private void writeStudents(List<Student> students) throws IOException {
        StringBuilder lines = new StringBuilder();
        students.forEach(s -> lines.append(s.formatForFileLine()));
        Files.write(STUDENTS_PATH, lines.toString().getBytes());
    }

    @Override
    public void deleteStudent(int id) throws Exception {
        List<Student> students = selectStudents();
        students.removeIf(s -> s.getId() == id);
        writeStudents(students);
    }

    @Override
    public Student selectStudent(int id) throws Exception {
        Optional<Student> optStudent = selectStudents()
                .stream()
                .filter(s -> s.getId() == id)
                .findFirst();
        if (optStudent.isPresent()) {
            return optStudent.get();
        }
        return null;
    }

    @Override
    public List<Student> selectStudents() throws Exception {
        List<Student> students = new ArrayList();
        List<String> lines = Files.readAllLines(STUDENTS_PATH);        
        lines.forEach(line -> students.add(Student.parseFromFileLine(line)));
        return students;    
    }
    
}
