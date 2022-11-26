package ru.bratusev.cybergardenhack.models;

public class LectureModel {
    private String para;
    private String cabinet;
    private String sines;
    private String time;
    private String teacher;

    public LectureModel(String para, String cabinet, String sines, String time, String teacher) {
        this.para = para;
        this.cabinet = cabinet;
        this.sines = sines;
        this.time = time;
        this.teacher = teacher;
    }

    public String getPara() {
        return para;
    }

    public String getCabinet() {
        return cabinet;
    }

    public String getSines() {
        return sines;
    }

    public String getTime() {
        return time;
    }

    public String getTeacher() {
        return teacher;
    }
}
