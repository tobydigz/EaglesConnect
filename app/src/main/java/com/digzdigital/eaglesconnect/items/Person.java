package com.digzdigital.eaglesconnect.items;

import io.realm.RealmObject;

/**
 * Created by Digz on 25/08/2016.
 */
public class Person extends RealmObject {

    private String name;
    private String entryYear;
    private String exitYear;
    private String location;
    private String email;
    private String phone;
    private byte[] image;
    private int imageResId;
    private String birthday;
    private String course;

    public Person(){

    }

    public Person(String name, int resId ){
        this.name = name;
        this.imageResId = resId;
    }
    public Person(String name, String entryYear, String exitYear, String location, String course, String email, String phone, int imageResId, String birthday){
        this.name = name;
        this.entryYear = entryYear;
        this.exitYear = exitYear;
        this.location = location;
        this.course = course;
        this.email = email;
        this.phone = phone;
        this.imageResId = imageResId;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEntryYear() {
        return entryYear;
    }

    public void setEntryYear(String entryYear) {
        this.entryYear = entryYear;
    }

    public String getExitYear() {
        return exitYear;
    }

    public void setExitYear(String exitYear) {
        this.exitYear = exitYear;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
