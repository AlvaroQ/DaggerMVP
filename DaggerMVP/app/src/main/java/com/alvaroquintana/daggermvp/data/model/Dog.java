package com.alvaroquintana.daggermvp.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.alvaroquintana.daggermvp.data.Net.Services;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alvaro Quintana on 24-Apr-18.
 */
public class Dog implements Parcelable {
    private String id;
    private String name;
    private String icon;
    private String origen;
    private String description;
    private int comments;
    private String tamano;
    private int longevidad;
    private FCI fci;
    private List<String> otherNames;

    public List<String> getOtherNames() {
        if(otherNames == null) {
            otherNames = new ArrayList<>();
        }
        return otherNames;
    }

    public void setOtherNames(List<String> otherNames) {
        this.otherNames = otherNames;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return Services.BASE_URL + icon;
    }

    public void setIcon(String Image) {
        this.icon = icon;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getOrigen() {
        return Services.FLAG_URL + origen + ".png";
    }

    public String getDescription() {
        return description;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public int getLongevidad() {
        return longevidad;
    }

    public void setLongevidad(int longevidad) {
        this.longevidad = longevidad;
    }

    public FCI getFci() {
        return fci;
    }

    public void setFci(FCI fci) {
        this.fci = fci;
    }

    public String toString()
    {
        return name;
    }

    public Dog(){
        otherNames = new ArrayList<String>();
    }

    public Dog(String id, String name, String icon, String origen, String table, String tamano, int longevidad) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.origen = origen;
        this.tamano = tamano;
        this.longevidad = longevidad;
    }


    public Dog(Dog dog) {
        this.id = dog.id;
        this.name = dog.name;
        this.icon = dog.icon;
        this.origen = dog.origen;
        this.description = dog.description;
        this.comments = dog.comments;
        this.tamano = dog.tamano;
        this.longevidad = dog.longevidad;
        this.fci = dog.fci;
        this.otherNames = dog.otherNames;
    }

    ///// PARCELABLE PART /////
    @Override
    public int describeContents() {
        return 0;
    }

    public Dog(Parcel in) {
        this();
        readFromParcel(in);
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.icon);
        dest.writeString(this.origen);
        dest.writeString(this.description);
        dest.writeInt(this.comments);
        dest.writeString(this.tamano);
        dest.writeInt(this.longevidad);
        dest.writeParcelable(this.fci, flags);
        dest.writeStringList(this.otherNames);
    }

    public static final Creator<Dog> CREATOR = new Creator<Dog>() {
        public Dog createFromParcel(Parcel source) {
            return new Dog(source);
        }

        public Dog[] newArray(int size) {
            return new Dog[size];
        }
    };

    /*
    * Constructor calls read to create object
    */
    private void readFromParcel(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.icon = in.readString();
        this.origen = in.readString();
        this.description = in.readString();
        this.comments = in.readInt();
        this.tamano = in.readString();
        this.longevidad = in.readInt();
        this.fci = in.readParcelable(FCI.class.getClassLoader());
        in.readStringList(this.otherNames);
    }
}
