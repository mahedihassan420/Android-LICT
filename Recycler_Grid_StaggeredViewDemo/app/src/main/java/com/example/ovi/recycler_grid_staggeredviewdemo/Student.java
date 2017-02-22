package com.example.ovi.recycler_grid_staggeredviewdemo;

/**
 * Created by Ovi on 2/22/2017.
 */

public class Student {
    private String name, group, year;

    public Student() {
    }

    public Student(String name, String group, String year) {
        this.name = name;
        this.group = group;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name1) {
        this.name = name1;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group1) {
        this.group = group1;
    }
}
