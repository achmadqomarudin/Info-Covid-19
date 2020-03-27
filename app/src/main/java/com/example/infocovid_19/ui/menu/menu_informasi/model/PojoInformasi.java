package com.example.infocovid_19.ui.menu.menu_informasi.model;

public class PojoInformasi {

    private int image;
    private int colorBg;
    private String title;

    public PojoInformasi(int image, int colorBg, String title) {
        this.image = image;
        this.colorBg = colorBg;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getColorBg() {
        return colorBg;
    }

    public void setColorBg(int colorBg) {
        this.colorBg = colorBg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
