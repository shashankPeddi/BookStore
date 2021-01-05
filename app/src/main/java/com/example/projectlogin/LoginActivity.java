package com.example.projectlogin;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
DatabaseHelper databaseHelper;
EditText et1,et2;
Button login;
int log=0;
int c=0;
String[] em;String[] ps;int ind=0,ind1=0,ind2=0;
String[] cid;
String custid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        databaseHelper=new DatabaseHelper(this);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
         Cursor data = databaseHelper.getData();
         Cursor data1 = databaseHelper.getData();
        login=findViewById(R.id.login);
        while(data.moveToNext()){
            c++;
//                    if(et1.getText().toString().equalsIgnoreCase(data.getString(3))&&
//                            et2.getText().toString().equalsIgnoreCase(data.getString(5)))
//                    {
//                        log=1;
//                        break;
//                    }
        }
        em = new String[c];ps=new String[c];cid=new String[c];
        while(data1.moveToNext()){
         em[ind++]=data1.getString(3);
         ps[ind1++]=data1.getString(5);
         cid[ind2++]=data1.getString(1);

                    }

        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                for(int i=0;i<ind;i++)
                {
                    if(et1.getText().toString().equals(em[i])&&et2.getText().toString().equals(ps[i]))
                    {

                        log=1;
                        custid=cid[i];
                        break;
                    }
                }
                if(log==1)
                {
                    Intent in = new Intent(LoginActivity.this,ProjectUpload.class)
                            ;
                    in.putExtra("customerid",custid);
                    startActivity(in);finish();

                }
                else
                    Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();

            }

        });
    }

}