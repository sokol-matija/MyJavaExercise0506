package hr.algebra.dal.file;

import hr.algebra.dal.Repository;
import hr.algebra.model.Student;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class FileRepository implements Repository {

    private static final String DIR = "files";
    private static final Path DIR_PATH = Paths.get(DIR);
    private static final Path STUDENT_PATH
            = Paths.get(DIR + File.separator + "students.txt");

    public FileRepository() throws IOException {
        if (!Files.exists(STUDENT_PATH)) {
            Files.createDirectories(DIR_PATH);
            Files.createFile(STUDENT_PATH);
        }
    }

    @Override
    public int createStudent(Student student) throws Exception {
        int maxID = 0;

        OptionalInt max = selectStudents().stream()
                .mapToInt(Student::getId)
                .max();

        if (max.isPresent()) {
            maxID = max.getAsInt();
        }

        Files.write(
                STUDENT_PATH,
                student.format().getBytes(),
                StandardOpenOption.APPEND);
        return maxID;
    }

    @Override
    public void updateStudent(int id, Student data) throws Exception {

        List<Student> students = selectStudents();
        Optional<Student> opt = students.stream()
                .filter(s -> s.getId() == id)
                .findFirst();
        if (opt.isPresent()) {
            Student student = opt.get();
            student.update(data);
            writeStudents(students);
        }

    }

    @Override
    public void deleteStudent(int id) throws Exception {

    }

    @Override
    public Student selectStudent(int id) throws Exception {
        return selectStudents().stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Student> selectStudents() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void writeStudents(List<Student> students) throws IOException {
        StringBuilder lines = new StringBuilder();
        students.forEach(s -> lines.append(s.format()));
        Files.write(STUDENT_PATH, lines.toString().getBytes());
    }

}
