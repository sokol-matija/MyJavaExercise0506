package hr.algebra.view.model;

import hr.algebra.model.Student;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class StudentTableModel extends AbstractTableModel {

    private List<Student> students;

    public StudentTableModel(List<Student> students) {
        this.students = students;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return students.size();
    }

    private static final String[] COLUMNS = {
        "ID",
        "First name",
        "Last name",
        "Grade",
        "Picture Path"
    };

    @Override
    public int getColumnCount() {
        return COLUMNS.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMNS[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 1:
                students.get(rowIndex).getId();
            case 2:
                students.get(rowIndex).getFirstName();
            case 3:
                students.get(rowIndex).getLastName();
            case 4:
                students.get(rowIndex).getGrade();
            case 5:
                students.get(rowIndex).getPicturePath();
            default:
                throw new AssertionError();
        }
    }

}
