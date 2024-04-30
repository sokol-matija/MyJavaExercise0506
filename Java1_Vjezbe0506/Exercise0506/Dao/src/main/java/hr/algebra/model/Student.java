/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

/**
 *
 * @author dnlbe
 */
public class Student {

    private static final String DELIMITER = ";";

    private int id;
    private String firstName;
    private String lastName;
    private Grade grade;
    private String picturePath;

    public Student(int id, String firstName, String lastName, Grade grade, String picturePath) {
        this(firstName, lastName, grade, picturePath);
        this.id = id;
    }
    

    public Student(String firstName, String lastName, Grade grade, String picturePath) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.picturePath = picturePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String formatForFileLine() {
        return 
                id + DELIMITER 
                + firstName + DELIMITER 
                + lastName + DELIMITER 
                + grade.getGrade() + DELIMITER 
                + picturePath + System.lineSeparator();
    }
    
    public static Student parseFromFileLine(String line) {
        String[] details = line.split(DELIMITER);
        return new Student(
                Integer.parseInt(details[0]),
                details[1], 
                details[2], 
                Grade.from(Integer.parseInt(details[3])),
                details[4]);        
    }
}
