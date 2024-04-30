/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.view.model;

import hr.algebra.model.Student;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dnlbe
 */
public class StudentTableModel extends AbstractTableModel{
    
    private static final String[] COLUMN_NAMES = {"Id", "First name", "Last name", "Grade", "Picture path"};
    
    private List<Student> students;

    public StudentTableModel(List<Student> students) {
        this.students = students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return Student.class.getDeclaredFields().length - 1; // we do not need static DELIMITER field!!!
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return students.get(rowIndex).getId();
            case 1:
                return students.get(rowIndex).getFirstName();
            case 2:
                return students.get(rowIndex).getLastName();
            case 3:
                return students.get(rowIndex).getGrade();
            case 4:
                return students.get(rowIndex).getPicturePath();
            default:
                throw new RuntimeException("No such column");
        }
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }
}
