package com.digzdigital.eaglesconnect.items;

import io.realm.RealmObject;

/**
 * Created by Digz on 26/08/2016.
 */
public class Forum  extends RealmObject{
    private String name;
    private String description;
    private byte[] image;
    private int imageResId;

    public Forum(){

    }

    public Forum(String name, String description, int imageResId){
        this.name = name;
        this.description = description;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }
}
