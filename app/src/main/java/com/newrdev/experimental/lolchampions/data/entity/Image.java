package com.newrdev.experimental.lolchampions.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rudolph on 5/17/17.
 */

public class Image implements Parcelable {

    private String full;
    private String group;
    private String sprite;
    private int h;
    private int w;
    private int y;
    private int x;

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public Integer getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.full);
        dest.writeString(this.group);
        dest.writeString(this.sprite);
        dest.writeInt(this.h);
        dest.writeInt(this.w);
        dest.writeInt(this.y);
        dest.writeInt(this.x);
    }

    protected Image(Parcel in) {
        this.full = in.readString();
        this.group = in.readString();
        this.sprite = in.readString();
        this.h = in.readInt();
        this.w = in.readInt();
        this.y = in.readInt();
        this.x = in.readInt();
    }

    public static final Parcelable.Creator<Image> CREATOR = new Parcelable.Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel source) {
            return new Image(source);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };
}
