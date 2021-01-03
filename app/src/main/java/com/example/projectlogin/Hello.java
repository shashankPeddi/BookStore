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
    String[] str = {"Telugu","Hindi","Engliish","Math"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        container = (LinearLayout) findViewById(R.id.goa);
        for(int i=0;i<str.length;i++){

            if(str[i]!=null)

                addItems(str[i]);
        }
    }
    public void addItems(String a) {
        LayoutInflater layoutInflater =
                (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View addView = layoutInflater.inflate(R.layout.list, null);

        final TextView vv = (TextView) addView.findViewById(R.id.subj);

        final Button add = (Button)addView.findViewById(R.id.add);

        vv.setText(""+a.toString());
        container.addView(addView);

    }
}
