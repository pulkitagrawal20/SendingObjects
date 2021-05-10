package com.example.android.sendingobjects.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {
   private String name;
   private String gender;
   private String rollNo;
   private String mobileNo;

   public Student(){

   }

    @Override
    public int describeContents() {
        return 0;
    }

   public Student(String name, String gender, String rollNo, String mobileNo){
       this.name=name;
       this.gender=gender;
       this.rollNo=rollNo;
       this.mobileNo=mobileNo;
   }

   protected Student(Parcel in){
       String[] data=new String[4];
       in.readStringArray(data);

       this.name=data[0];
       this.gender=data[1];
       this.rollNo=data[2];
       this.mobileNo=data[3];
   }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{this.name,
        this.gender,
        this.rollNo,
        this.mobileNo});

    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
   //Getters for all Fields

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }
}
