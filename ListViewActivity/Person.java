package com.eskisehirgyk.listviewactivity;

public class Person {

    private String item1Value;
    private String itemValue2;
    private int image;

    public Person(String item1Value, String itemValue2, int image) {
        this.item1Value = item1Value;
        this.itemValue2 = itemValue2;
        this.image = image;
    }

    public Person(String item1Value, String itemValue2) {
        this.item1Value = item1Value;
        this.itemValue2 = itemValue2;
    }

    public String getItem1Value() {
        return item1Value;
    }

    public void setItem1Value(String item1Value) {
        this.item1Value = item1Value;
    }

    public String getItemValue2() {
        return itemValue2;
    }

    public void setItemValue2(String itemValue2) {
        this.itemValue2 = itemValue2;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
