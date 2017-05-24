package com.newrdev.experimental.lolchampions.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by rudolph on 5/17/17.
 */

public class Champion implements Parcelable {
    @SerializedName("image")
    @Expose
    private Image image;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("name")
    @Expose
    private String name;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.image, flags);
        dest.writeString(this.title);
        dest.writeInt(this.id);
        dest.writeString(this.key);
        dest.writeString(this.name);
    }

    protected Champion(Parcel in) {
        this.image = in.readParcelable(Image.class.getClassLoader());
        this.title = in.readString();
        this.id = in.readInt();
        this.key = in.readString();
        this.name = in.readString();
    }

    public static final Parcelable.Creator<Champion> CREATOR = new Parcelable.Creator<Champion>() {
        @Override
        public Champion createFromParcel(Parcel source) {
            return new Champion(source);
        }

        @Override
        public Champion[] newArray(int size) {
            return new Champion[size];
        }
    };
}
