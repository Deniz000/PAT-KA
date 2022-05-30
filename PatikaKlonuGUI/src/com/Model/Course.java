package com.Model;

public class Course {
    private int id;
    private int educatorId;
    private int patikaId;
    private String name;
    private String language;
    private Patika patika;
    private User educator;

    public Course(int id, int educatorId, int patikaId, String name, String language) {
        this.id = id;
        this.educatorId = educatorId;
        this.patikaId = patikaId;
        this.name = name;
        this.language = language;
        this.patika = Patika.getFetch(getPatikaId());
        this.educator = User.getFetch(getEducatorId());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEducatorId() {
        return educatorId;
    }

    public void setEducatorId(int educatorId) {
        this.educatorId = educatorId;
    }

    public int getPatikaId() {
        return patikaId;
    }

    public void setPatikaId(int patikaId) {
        this.patikaId = patikaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
