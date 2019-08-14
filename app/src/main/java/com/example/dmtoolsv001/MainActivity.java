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

        Resources res = getResources();
        MainActivityListView = (ListView)findViewById(R.id.MainMenuListView);
        MainActivityChoicesText = res.getStringArray(R.array.MainActivityChoicesText);

        MainActivityListView.setAdapter(new ArrayAdapter<String>(this, R.layout.main_activity_listview_layout, MainActivityChoicesText));

        MainActivityListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                switch(position){
                    case 0:
                        //launch activity affiliated with choice 0
                            Intent intentDiceRoller = new Intent(MainActivity.this, DiceRollerActivity.class);
                            startActivity(intentDiceRoller);
                        break;
                    case 1:
                        //launch activity affiliated with choice 1
                        Intent intentNPCGenerator = new Intent(MainActivity.this, NPCGeneratorActivity.class);
                        startActivity(intentNPCGenerator);
                        break;
                    case 2:
                        Intent intentLootGenerator = new Intent(MainActivity.this, LootGeneratorActivity.class);
                        startActivity(intentLootGenerator);
                        break;
                }
            }
        });

    }
}
