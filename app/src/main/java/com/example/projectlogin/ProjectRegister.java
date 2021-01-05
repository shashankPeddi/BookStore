package com.example.projectlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class ProjectRegister extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;
EditText et1,et2,et3,et4;
Random r = new Random();
int rand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_register);
         rand = r.nextInt(10000);
        mDatabaseHelper=new DatabaseHelper(this);
et1=findViewById(R.id.name);et2=findViewById(R.id.email);et3=findViewById(R.id.phone);et4=findViewById(R.id.pass);
    }
    public void AddData(String src,String dest,String ar,String dept) {

        try {
            if (src != null && dest  != null && ar  != null&& dept  != null) {
                boolean insertData = mDatabaseHelper.addData(String.valueOf(rand),src,dest,ar,dept);

                if (insertData) {
                    toastMessage("Data Successfully Inserted!");
                } else {
                    toastMessage("Something went wrong");
                }
            }
        }
        catch (Exception e)
        {
            toastMessage(" "+e);
        }
    }
    public void toastMessage(String nm){
        Toast.makeText(this, ""+nm, Toast.LENGTH_SHORT).show();
    }

    public void Save(View view) {
        AddData(et1.getText().toString(),et2.getText().toString(),et3.getText().toString(),et4.getText().toString());
        Intent intent =new Intent(ProjectRegister.this,Hello.class);startActivity(intent);finish();
    }
    public void Loginn(View view) {
        Intent intent = new Intent(ProjectRegister.this,LoginActivity.class);
        startActivity(intent);
    }
}
