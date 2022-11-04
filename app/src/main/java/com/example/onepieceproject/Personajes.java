package com.example.onepieceproject;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Personajes implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;
    private String race;
    private int age;
    private int height;
    private String devilfruit;
    private String userimg; //link de imagen
    private String dfimage; //link de imagen


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getDevilfruit() {
        return devilfruit;
    }

    public void setDevilfruit(String devilfruit) {
        this.devilfruit = devilfruit;
    }

    public String getUserimg() {
        return userimg;
    }

    public void setUserimg(String userimg) {
        this.userimg = userimg;
    }

    public String getDfimage() {
        return dfimage;
    }

    public void setDfimage(String dfimage) {
        this.dfimage = dfimage;
    }

    @Override
    public String toString() {
        return "Personajes{" +
                "name='" + name + '\'' +
                ", race='" + race + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", devilfruit='" + devilfruit + '\'' +
                ", userimg='" + userimg + '\'' +
                ", dfimage='" + dfimage + '\'' +
                '}';
    }
}