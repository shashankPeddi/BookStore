package com.example.projectlogin;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ViewAllBooks extends AppCompatActivity {
DatabaseHelperL mDatabaseHelper;
String cate;
Cursor data;
Cursor data1;
LinearLayout container;
int c=0;String cid[];String bname[];String sub[];String author[];
        int ind1=0,ind2=0,ind3=0,ind4=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_books);
        container= (LinearLayout)findViewById(R.id.container);
        Intent intent = getIntent();
        cate=intent.getStringExtra("category");
        mDatabaseHelper = new DatabaseHelperL(this);
        data=mDatabaseHelper.getData();
        data1=mDatabaseHelper.getData();
        while(data.moveToNext())
            c++;
        if(c==0)
            Toast.makeText(this, "No books in this category", Toast.LENGTH_SHORT).show();
        else {
            cid = new String[c];
            bname = new String[c];
            sub = new String[c];
            author = new String[c];
            while (data1.moveToNext()) {
                cid[ind1++] = data1.getString(1);
                bname[ind2++] = data1.getString(2);
                sub[ind3++] = data1.getString(3);
                author[ind4++] = data1.getString(4);
            }
            for(int i=0;i<ind1;i++) {

                addItems(bname[i], sub[i], author[i]);
            }
        }

    }
    public void addItems(String b,String s,String a) {
        LayoutInflater layoutInflater =
                (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View addView = layoutInflater.inflate(R.layout.book_list, null);

        final TextView bname = (TextView) addView.findViewById(R.id.bname);
    //    final TextView subject = (TextView) addView.findViewById(R.id.subject);
      //  final TextView author = (TextView) addView.findViewById(R.id.author);
        final Button add = (Button)addView.findViewById(R.id.add);

        bname.setText("\n  "+b.toString()+"\nSubj:"+s.toString()+"\nAuthor:"+a.toString());
        //subject.setText(""+s.toString());
       // author.setText(""+a.toString());

        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            }
        });

        container.addView(addView);
    }
}
