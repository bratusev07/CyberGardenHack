package ru.bratusev.cybergardenhack.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CalendarModel {
    @SerializedName("1")
    private List<String> _1 = null;
    @SerializedName("2")
    private List<String> _2 = null;
    @SerializedName("3")
    private List<String> _3 = null;
    @SerializedName("4")
    private List<String> _4 = null;
    @SerializedName("5")
    private List<String> _5 = null;
    @SerializedName("6")
    private List<String> _6 = null;
    @SerializedName("7")
    private List<String> _7;

    public LectureModel get_1() {
        LectureModel model;
        try {
            model = new LectureModel("Первая пара", _1.get(2), _1.get(0), "08:00-09:35", _1.get(1));
        } catch (Exception e) {
            model = new LectureModel("пусто", "пусто", "пусто", "пусто", "пусто");
        }
        return model;
    }

    public LectureModel get_2() {
        LectureModel model;
        try {
            model = new LectureModel("Вторая пара", _2.get(2), _2.get(0), "09:50-11:25", _2.get(1));
        } catch (Exception e) {
            model = new LectureModel("пусто", "пусто", "пусто", "пусто", "пусто");
        }
        return model;
    }

    public LectureModel get_3() {
        LectureModel model;
        try {
            model = new LectureModel("Третья пара", _3.get(2), _3.get(0), "11:55-13:30", _3.get(1));
        } catch (Exception e) {
            model = new LectureModel("пусто", "пусто", "пусто", "пусто", "пусто");
        }
        return model;
    }

    public LectureModel get_4() {
        LectureModel model;
        try {
            model = new LectureModel("Четвёртая пара", _4.get(2), _4.get(0), "13:45-15:20", _4.get(1));
        } catch (Exception e) {
            model = new LectureModel("пусто", "пусто", "пусто", "пусто", "пусто");
        }
        return model;
    }

    public LectureModel get_5() {
        LectureModel model;
        try {
            model = new LectureModel("Пятая пара", _5.get(2), _5.get(0), "15:50-17:25", _5.get(1));
        } catch (Exception e) {
            model = new LectureModel("пусто", "пусто", "пусто", "пусто", "пусто");
        }
        return model;
    }

    public LectureModel get_6() {
        LectureModel model;
        try {
            model = new LectureModel("Шестая пара", _6.get(2), _6.get(0), "17:40-19:15", _6.get(1));
        } catch (Exception e) {
            model = new LectureModel("пусто", "пусто", "пусто", "пусто", "пусто");
        }
        return model;
    }

    public LectureModel get_7() {
        LectureModel model;
        try {
            model = new LectureModel("Седьмая пара", _7.get(2), _7.get(0), "19:30-21:05", _7.get(1));
        } catch (Exception e) {
            model = new LectureModel("пусто", "пусто", "пусто", "пусто", "пусто");
        }
        return model;
    }
}
