package godgiven_school;

import java.util.ArrayList;

public class student extends person{
    private String reshte;
    ArrayList<lesson> lessons = new ArrayList<lesson>();
    private String nomre;

    public student() {
    }

    public student(String fullname, String id, String nomre) {
        super(fullname, id);
        this.nomre = nomre;
    }

    public student(String fullname, String id) {
        super(fullname, id);
    }

    public void setNomre(String nomre) {
        this.nomre = nomre;
    }

    public ArrayList<lesson> getLessons() {
        return lessons;
    }

    public void setLessons(ArrayList<lesson> lessons) {
        this.lessons = lessons;
    }

    public String getNomre() {
        return nomre;
    }

    public String getReshte() {
        return reshte;
    }

    public void setReshte(String reshte) {
        this.reshte = reshte;
    }
}
