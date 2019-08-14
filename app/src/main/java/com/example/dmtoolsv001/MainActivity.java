package com.example.dmtoolsv001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Begin Code for Main
        Button DiceRollerActivityButton = (Button)findViewById(R.id.DiceRollerActivityButton);
        DiceRollerActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent DiceRollerIntent = new Intent(getApplicationContext(),DiceRollerActivity.class);
                startActivity(DiceRollerIntent);
            }
        });
    }
}
