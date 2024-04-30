package hr.algebra.model;

public final class Student {

    private static final String DEL = ";";

    public String format() {
        return id
                + DEL + firstName
                + DEL + lastName
                + DEL + grade.getGrade()
                + DEL + picturePath;
    }

    public static Student parseStudent(String line) {
        String[] deatils = line.split(DEL);

        return new Student(
                Integer.parseInt(deatils[0]),
                deatils[1],
                deatils[2],
                Grade.from(Integer.parseInt(deatils[3])),
                deatils[4]);
    }

    public void update(Student data) {
        setFirstName(data.getFirstName());
        setLastName(getLastName());
        setGrade(getGrade());
        setPicturePath(getPicturePath());
    }

    private int id;
    private String firstName;
    private String lastName;
    private Grade grade;
    private String picturePath;

    public Student(int id, String firstName, String lastName, Grade grade, String picturePath) {
        this(firstName, lastName, grade, picturePath);
        setId(id);
    }

    public Student(String firstName, String lastName, Grade grade, String picturePath) {
        setFirstName(firstName);
        setLastName(lastName);
        setGrade(grade);
        setPicturePath(picturePath);
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

}
