package com.example.projectlogin;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
public class Hello extends AppCompatActivity {
    LinearLayout container;
    int c=0;
    DatabaseHelper mDatabaseHelper;
    String[] str = {"Telugu","Hindi","Engliish","Math"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        mDatabaseHelper = new DatabaseHelper(this);
        container = (LinearLayout) findViewById(R.id.goa);
        Cursor data = mDatabaseHelper.getData();
        Cursor data1 = mDatabaseHelper.getData();
        Cursor data2 = mDatabaseHelper.getData();
        while (data.moveToNext()) {
            //get the value from the database in column 1
            //then add it to the ArrayList
            c++;
            //listData.add(data.getString(1));
        }
        String[] k = new String[c];
        int ind=0;
        while (data1.moveToNext()) {
            String src= data1.getString(1);
            String dep = data1.getString(2);
            k[ind++]=src+"-"+dep;
            //  Toast.makeText(this, ""+data.getString(2), Toast.LENGTH_SHORT).show();
            //listData.add(data.getString(1));
        }
        for(int i=0;i<k.length;i++){
            if(k[i]!=null)
                addItems(k[i]);
        }
    }
    public void addItems(String a)
    {
        LayoutInflater layoutInflater =
                (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View addView = layoutInflater.inflate(R.layout.list, null);

        final TextView vv = (TextView) addView.findViewById(R.id.subj);

        final Button add = (Button)addView.findViewById(R.id.add);

        vv.setText(""+a.toString());
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

            }
        });
        container.addView(addView);

    }
}
