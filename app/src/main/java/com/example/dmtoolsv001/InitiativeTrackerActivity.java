package com.example.dmtoolsv001;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class InitiativeTrackerActivity extends AppCompatActivity {
    //PartyArrayList
    Intent intent = getIntent();
    ArrayList<CharacterEntry> PartyArrayList = intent.getParcelableArrayListExtra("PARTY_ARRAY_LIST");

    //variables
    int RoundTrackerint;
    /*!*///int NumberOfCombatants = 2; /*Change this to be a non-initializer; set equal to length of listarray gotten from intro activity*/
    int NumberOfCombatants = PartyArrayList.size();
    int TurnsElapsed = 0;
    //XML Elements
    TextView RoundTrackerTextView;
/**/TextView NumberOfCombatantsTextView; /*Used for debug. Will Remove for final code*/
    Button NextTurnButton = findViewById(R.id.NextTurnButton);





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initiative_tracker);
        RoundTrackerTextView = findViewById(R.id.RoundTrackerTextView);
        NumberOfCombatantsTextView = findViewById(R.id.NumberOfCombatantsTextView);
        NumberOfCombatantsTextView.setText(NumberOfCombatants + "");

        NextTurnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TurnsElapsed ++;
                RoundTrackerint = (TurnsElapsed/NumberOfCombatants)+1;
                RoundTrackerTextView.setText("Round: "+RoundTrackerint);
            }
        });



    }
}
