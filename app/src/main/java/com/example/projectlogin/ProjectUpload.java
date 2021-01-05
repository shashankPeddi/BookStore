package com.example.projectlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ProjectUpload extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] bankNames={"select","0-5","6-10","11-12","over and above "};
    String customerid;
    String category;
    EditText bname,author,subject;
    String btype;
    Button upload;
    DatabaseHelperL mDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_upload);
        upload = findViewById(R.id.upload);
        mDatabaseHelper = new DatabaseHelperL(this);
        Intent intent = getIntent();
        customerid = intent.getStringExtra("customerid");
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);
        bname=findViewById(R.id.bname);
        author=findViewById(R.id.author);
        subject=findViewById(R.id.subject);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddData(customerid,bname.getText().toString(),subject.getText().toString(),author.getText().toString(),category
                );
                Intent intent1 = new Intent(ProjectUpload.this,Success.class);
                startActivity(intent1);
            }
        });
//Creating the ArrayAdapter instance having the bank name list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,bankNames);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
    }


    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(), bankNames[position], Toast.LENGTH_LONG).show();
        category=bankNames[position].toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
// TODO Auto-generated method stub

    }
    public void AddData(String cid,String bname,String subj,String author,String category) {

        try {
            if (cid != null && bname  != null && subj  != null&& author  != null && category!=null) {
                boolean insertData = mDatabaseHelper.addData(cid,bname,subj,author,category);

                if (insertData) {
                    toastMessage("New Book uploaded successfully!");
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
    public void toastMessage(String s){
        Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
    }
    }

