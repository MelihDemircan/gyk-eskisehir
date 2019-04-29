package com.eskisehirgyk.gezginapplication;

public class HomeItemModel {

    private int image;
    private String title;
    private String message;
    private String imageUrl;

    public HomeItemModel() {

    }

    public HomeItemModel(int image, String title, String message,String imageUrl) {
        this.image = image;
        this.title = title;
        this.message = message;
        this.imageUrl = imageUrl;
    }

    public HomeItemModel(int image, String title, String message) {
        this.image = image;
        this.title = title;
        this.message = message;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
