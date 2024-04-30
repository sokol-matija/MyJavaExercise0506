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
public enum Grade {

    EXCELLENT(5),
    VERY_GOOD(4),
    GOOD(3),
    SATISFACTORY(2),
    FAIL(1);

    private final int grade;
    
    private Grade(int grade) {
        this.grade = grade;
    }
    
    public int getGrade() {
        return grade;
    }

    public static Grade from(int grade) {
        for (Grade value : values()) {
            if (value.grade == grade) {
                return value;
            }
        }
        throw new RuntimeException("No such grade");
    }

}
