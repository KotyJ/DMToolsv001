package com.example.dmtoolsv001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView MainActivityListView;
    String[] MainActivityChoicesText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Begin Code for Main

        final Resources res = getResources();

        MainActivityListView = (ListView)findViewById(R.id.MainMenuListView);
        MainActivityChoicesText = res.getStringArray(R.array.MainActivityChoicesText);

        MainActivityListView.setAdapter(new ArrayAdapter<String>(this, R.layout.main_activity_listview_layout, MainActivityChoicesText));

        MainActivityListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent();
                final String[] ChoiceArray = res.getStringArray(R.array.MainActivityChoicesClasses);
                intent.setClassName(getApplicationContext(),ChoiceArray[position]);
            }
        });

    }
}
