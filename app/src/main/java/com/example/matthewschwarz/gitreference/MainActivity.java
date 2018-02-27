package com.example.matthewschwarz.gitreference;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public String processData(String filename){
        String jsonstring = "";
        boolean isFilePresent = JsonUtils.isFilePresent(this, filename);

        if(isFilePresent){
            jsonstring = JsonUtils.read(this, filename);

        }
    }
}
