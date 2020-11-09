package com.example.parcelable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.view.View;

import com.example.parcelable.databinding.ActivityMainBinding;

import java.sql.BatchUpdateException;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.edName.getText().toString();
                int age = Integer.parseInt(binding.edAge.getText().toString());
                int math = Integer.parseInt(binding.edMath.getText().toString());
                int english = Integer.parseInt(binding.edEnglish.getText().toString());
                Student student = new Student(name,age,new Student.Score(math,english));
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);

                Bundle bundle = new Bundle();
                bundle.putParcelable("student",student);
                intent.putExtra("Data",bundle);
                startActivity(intent);
            }
        });

    }

}