package com.example.abacus.mvpwithretrofit.data.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Actors implements Parcelable{

    @Expose
    @SerializedName("name")
    private String name;


    @Expose
    @SerializedName("description")
    private String description;


    @Expose
    @SerializedName("spouse")
    private String spouse;


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static Creator<Actors> getCREATOR() {
        return CREATOR;
    }

    @Expose
    @SerializedName("image")
    private String image;


    protected Actors(Parcel in) {
        name = in.readString();
        description = in.readString();
        spouse = in.readString();
        image = in.readString();
    }

    public static final Creator<Actors> CREATOR = new Creator<Actors>() {
        @Override
        public Actors createFromParcel(Parcel in) {
            return new Actors(in);
        }

        @Override
        public Actors[] newArray(int size) {
            return new Actors[size];
        }
    };

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

    public String getSpouse() {
        return spouse;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(spouse);
        dest.writeString(image);
    }
}
