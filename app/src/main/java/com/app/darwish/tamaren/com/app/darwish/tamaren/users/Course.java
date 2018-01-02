package com.app.darwish.tamaren.com.app.darwish.tamaren.users;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Darwish on 12/31/2017.
 */

public class Course implements Parcelable {
private int id;
private String name;
private int process;
private String imageUrl=null;



    public Course() {
    }

    protected Course(Parcel in) {
        id = in.readInt();
        name = in.readString();
        process = in.readInt();
        imageUrl = in.readString();
    }

    public static final Creator<Course> CREATOR = new Creator<Course>() {
        @Override
        public Course createFromParcel(Parcel in) {
            return new Course(in);
        }

        @Override
        public Course[] newArray(int size) {
            return new Course[size];
        }
    };

    public Course(int i, String arabic, int i1) {
    id=i;name=arabic;process=i1;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProcess(int process) {
        this.process = process;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getProcess() {
        return process;
    }

    public String getImageUrl() {
        return imageUrl;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeInt(process);
        parcel.writeString(imageUrl);
    }
}
