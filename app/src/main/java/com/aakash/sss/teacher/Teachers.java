package com.aakash.sss.teacher;

public class Teachers {


    private String name;
    private String namepost;
    private int image;

    public Teachers(String name, String namepost, int image) {
        this.name = name;
        this.namepost = namepost;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getNamepost() {
        return namepost;
    }

    public int getImage() {
        return image;
    }
}