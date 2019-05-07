package com.example.problemstatementlesson3;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aa;
    ArrayList<Objects> object;
    Button ButtonA;
    Button ButtonI;
    Button ButtonE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = findViewById(R.id.lv);
        ButtonA = findViewById(R.id.ButtonAdd);
        ButtonE = findViewById(R.id.ButtonEmail);
        ButtonI = findViewById(R.id.ButtonInfo);

        //Creating object (weeks , grade)
        object = new ArrayList<Objects>();
        object.add(new Objects("Week 1" , "A"));
        object.add(new Objects("Week 2", "B"));
        object.add(new Objects("Week 3" , "C"));
        object.add(new Objects("Week 4" , "D"));

        //String result[]={};
        //for (int i =0; i < object.size() ; i++) {}


        //Link this activity object to rows.xml
        aa = new SecondArrayAdapter(this, R.layout.row, object);
        lv.setAdapter(aa);

        //Onclick listener for button info
        ButtonI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent to display data
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                //Set the URL to be used
                rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(rpIntent);
            }
        });



        //Onclicker listener for button add
        //ButtonAdd.setOnClickListener(new);


        //Onclick listener fot button Email
        ButtonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //The action you want this intent to do
                //ACTION_SEND is used to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);
                //Put essentials like

                //EMAIL ADDRESS
                email.putExtra(Intent.EXTRA_EMAIL , new String[]{"jason.lim.rp.sg@gmail.com"});

                //SUBJECT
                email.putExtra(Intent.EXTRA_SUBJECT,"");

                //BODY TEXT
                //email.putExtra(Intent.EXTRA_TEXT, editTextMessage.getText());

                // MIME type indicates email
                email.setType("message/rfc8222");
                //CreateChooser shows user a list of app that can handle this mime type which is email;
                startActivity(Intent.createChooser(email , "Choose an Email client :"));

            }
        });


    }
}
