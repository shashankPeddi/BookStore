package com.example.projectlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ProjectOption extends AppCompatActivity {
String category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_option);
    }

    public void other(View view) {
        Intent intent = new Intent(ProjectOption.this,ViewAllBooks.class);
        category="other and above";
        intent.putExtra("category",category);startActivity(intent);
    }

    public void levtwovel(View view) {
        Intent intent = new Intent(ProjectOption.this,ViewAllBooks.class);
        category="11-12";
        intent.putExtra("category",category);startActivity(intent);
    }

    public void sixtoten(View view) {
        Intent intent = new Intent(ProjectOption.this,ViewAllBooks.class);
        category="6-10";
        intent.putExtra("category",category);startActivity(intent);
    }

    public void zerotofive(View view) {
        Intent intent = new Intent(ProjectOption.this,ViewAllBooks.class);
        category="0-5";
        intent.putExtra("category",category);startActivity(intent);
    }
}
