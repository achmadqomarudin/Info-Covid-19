package com.example.infocovid_19.ui.menu.menu_informasi.model;

public class PojoInformasi {

    private int image;
    private String title;

    public PojoInformasi(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
