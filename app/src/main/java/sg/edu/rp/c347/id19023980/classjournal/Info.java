package sg.edu.rp.c347.id19023980.classjournal;

import java.io.Serializable;

public class Info implements Serializable {
    private String grade;
    private int week;

    public Info(String grade, int week) {
        this.grade = grade;
        this.week = week;
    }

    public String getGrade() {
        return grade;
    }

    public int getWeek() {
        return week;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setWeek(int week) {
        this.week = week;
    }
}
