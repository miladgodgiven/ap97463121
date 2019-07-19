package godgiven_school;

import java.util.ArrayList;

public class teacher extends person {

    ArrayList<lesson> lessons = new ArrayList<lesson>();

    private int lesson_num;

    public ArrayList<lesson> getLessons() {
        return lessons;
    }

    public void setLessons(ArrayList<lesson> lessons) {
        this.lessons = lessons;
    }



    public int getLesson_num() {
        return lesson_num;
    }

    public void setLesson_num(int lesson_num) {
        this.lesson_num = lesson_num;
    }


}
