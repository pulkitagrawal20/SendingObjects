package com.example.android.sendingobjects;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.example.android.sendingobjects.Models.Student;
import com.example.android.sendingobjects.databinding.ActivityObjectSenderBinding;

public class ObjectSenderActivity extends AppCompatActivity {
        ActivityObjectSenderBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_sender);

        b=ActivityObjectSenderBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        SaveOnClickListener();

        setupHideError();
    }

    private void SaveOnClickListener() {
        b.SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveData();
            }
        });
    }

    private void setupHideError() {
        TextWatcher myTextWatcher=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                hideError();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        b.name.getEditText().addTextChangedListener(myTextWatcher);
        b.RollNo.getEditText().addTextChangedListener(myTextWatcher);
        b.PhoneNo.getEditText().addTextChangedListener(myTextWatcher);
    }

    public void SaveData() {
        Student student =getInfo();

        if (student ==null){
            return;
        }
        Intent intent=new Intent(this,ObjectViewerActivity.class);
        intent.putExtra(Constants.STUDENT_KEY, student);

        startActivity(intent);
    }

    private Student getInfo() {
        //Name Of Student:
        String name=b.name.getEditText().getText().toString().trim();
        if(name.isEmpty()){
            b.name.setError("Please Enter Your Name!!");
            return null;
        }
        //Declaring gender:
        String gender;

        int type=b.radioGroup.getCheckedRadioButtonId();
        if(type==b.maleButton.getId()){
            gender="Male";
        }
        else if(type==b.femaleButton.getId()){
            gender="Female";
        }
        else{
            Toast.makeText(this,"Please Select your Gender!!", Toast.LENGTH_SHORT).show();
            return null;
        }
        //roll no of student:
        String rollNo=b.RollNo.getEditText().getText().toString().trim();
        if(rollNo.isEmpty()){
            b.RollNo.setError("Please Enter Your RollNo.!!");
            return null;
        }
        else if (!rollNo.matches("^\\d{2}[a-zA-Z]*\\d{3}")){
            b.RollNo.setError("Please Enter Valid Roll No.!!");
            return null;
        }
        //Mobile No of student:
        String MobileNo=b.PhoneNo.getEditText().getText().toString().trim();
        if(MobileNo.isEmpty()){
            b.RollNo.setError("Please Enter Your Mobile No.!!");
            return null;
        }
        else if(!MobileNo.matches("^\\d{10}")){
            b.PhoneNo.setError("Please Enter Correct Mobile No.!!");
            return null;
        }

        Student student =new Student(name,gender,rollNo,MobileNo);
        return student;
    }
    //Error hiding:
    private void hideError() {
        b.name.setError(null);
        b.RollNo.setError(null);
        b.PhoneNo.setError(null);
    }

}