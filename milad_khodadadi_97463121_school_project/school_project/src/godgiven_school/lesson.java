package godgiven_school;

import java.util.ArrayList;

public class lesson {

    private String name;
    private String id;
    private String teacher;
    private int student_num;
    ArrayList<student> students=new ArrayList<student>();
    private String nomre;

    public int getStudent_num() {
        return student_num;
    }

    public lesson() {
    }

    public lesson(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public ArrayList<student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<student> students) {
        this.students = students;
    }

    public void setStudent_num(int student_num) {
        this.student_num = student_num;
    }



    public void setNomre(String nomre) {
        this.nomre = nomre;
    }


    public String getNomre() {
        return nomre;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
