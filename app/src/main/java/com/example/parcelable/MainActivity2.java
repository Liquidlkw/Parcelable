package com.example.parcelable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.example.parcelable.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main2);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("Data");
        Student student = bundle.getParcelable("student");

        binding.edAge.setText(""+student.getAge());
        binding.edEnglish.setText(""+student.getScore().getEnglish());
        binding.edName.setText(""+student.getName());
        binding.edName.setText(""+student.getName());



    }
}