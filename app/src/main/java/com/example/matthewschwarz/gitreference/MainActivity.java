package com.example.matthewschwarz.gitreference;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView rowView;
    private Adapter adapter;
    ArrayList<GitReference> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rowView = findViewById(R.id.MainListView);
        itemList = populateData("gitReference.json");
        adapter = new Adapter(getApplicationContext(), itemList);

        rowView.setAdapter(adapter);

    }

    public ArrayList<GitReference> populateData(String fileName){
        String jsonString = processData(fileName);
        Log.i("JSON", jsonString);
        ArrayList<GitReference> references = JsonUtils.populateGitReferences(jsonString);
        return references;
        //return JsonUtils.populateGitReferences(fileName);
    }

    public String processData(String filename){
        String jsonstring = "";
        boolean isFilePresent = JsonUtils.isFilePresent(this, filename);

        if(isFilePresent){
            jsonstring = JsonUtils.read(this, filename);
            Log.i("JSON", "JSON file not present. Creating.......");
            InputStream inputStream = null;
            try{
                inputStream = getApplicationContext().getAssets().open("gitReference.json");

            }catch(Exception ex){
                System.out.println("gitReference file not found");
            }
            jsonstring = JsonUtils.parseJsonToString(inputStream);
            boolean isFileCreated = JsonUtils.create(this, filename, jsonstring);
            if(isFileCreated){
                Log.i("JSON", "Created the filesystem JSON");
            }else{
                Log.i("JSON", "Filesystem not created");

            }

        }
        return jsonstring;
    }
}
