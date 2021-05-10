package com.example.android.sendingobjects;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.android.sendingobjects.Models.Student;
import com.example.android.sendingobjects.databinding.ActivityObjectViewerBinding;


public class ObjectViewerActivity extends AppCompatActivity {
    ActivityObjectViewerBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        b= ActivityObjectViewerBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        //Giving Title:
        setTitle("DETAILS");

        //Getting Data Through Intents:
        getData();
    }

    private void getData() {
        //Getting intent from one activity to another:
        Student student=getIntent().getExtras().getParcelable(Constants.STUDENT_KEY);

        if(student==null){
            Toast.makeText(this,"No Data Received!!",Toast.LENGTH_SHORT).show();
            return;
        }

        //Showing data in Text Fields:
        b.name.getEditText().setText(student.getName());
        b.Gender.getEditText().setText(student.getGender());
        b.RollNo.getEditText().setText(student.getRollNo());
        b.PhoneNo.getEditText().setText(student.getMobileNo());
    }


}
