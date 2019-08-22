package com.example.dmtoolsv001;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Telephony;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ToggleButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ContextThemeWrapper;

public class InitiativeTrackerIntroActivity extends AppCompatActivity implements OnItemSelectedListener {

    //Declare XML Elements
    ArrayList<CharacterEntry> PartyArrayList = new ArrayList<>();
    Spinner CharacterClassSpinner;
    ToggleButton NewCharacterSTRProfToggleButton;
    ToggleButton NewCharacterDEXProfToggleButton;
    ToggleButton NewCharacterCONProfToggleButton;
    ToggleButton NewCharacterINTProfToggleButton;
    ToggleButton NewCharacterWISProfToggleButton;
    ToggleButton NewCharacterCHAProfToggleButton;
    EditText NewCharacterNameEditText;
    EditText NewCharacterLevelEditText;
    EditText NewCharacterArmorClassEditText;
    EditText NewCharacterMaxHitPointsEditText;
    EditText NewCharacterStrengthEditText;
    EditText NewCharacterDexterityEditText;
    EditText NewCharacterConstitutionEditText;
    EditText NewCharacterIntelligenceEditText;
    EditText NewCharacterWisdomEditText;
    EditText NewCharacterCharismaEditText;

    String newClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initiative_tracker_intro);
        //create party arraylist
/**/    //final ArrayList<CharacterEntry> PartyArrayList = new ArrayList<>();
        //initialize spinner
        CharacterClassSpinner = findViewById(R.id.NewCharacterClassSpinner);
        CharacterClassSpinner.setOnItemSelectedListener(this);
        List<String> CharacterClasses = new ArrayList<String>();
        CharacterClasses.add("Select Class");
        CharacterClasses.add("Artificer");
        CharacterClasses.add("Barbarian");
        CharacterClasses.add("Bard");
        CharacterClasses.add("Cleric");
        CharacterClasses.add("Druid");
        CharacterClasses.add("Fighter");
        CharacterClasses.add("Monk");
        CharacterClasses.add("Paladin");
        CharacterClasses.add("Ranger");
        CharacterClasses.add("Rogue");
        CharacterClasses.add("Sorcerer");
        CharacterClasses.add("Warlock");
        CharacterClasses.add("Wizard");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CharacterClasses);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        CharacterClassSpinner.setAdapter(dataAdapter);

        //Initialize rest of XML elements
        Button ImportPartyButton = findViewById(R.id.ImportPartyButton);
        Button NextButton = findViewById(R.id.NextButton);
        Button AddCharacterButton = findViewById(R.id.AddCharacterButton);
        NewCharacterSTRProfToggleButton = findViewById(R.id.StrengthProficientToggleButton);
        NewCharacterDEXProfToggleButton = findViewById(R.id.DexterityProficientToggleButton);
        NewCharacterCONProfToggleButton = findViewById(R.id.ConstitutionProficientToggleButton);
        NewCharacterINTProfToggleButton = findViewById(R.id.IntelligenceProficientToggleButton);
        NewCharacterWISProfToggleButton = findViewById(R.id.WisdomProficientToggleButton);
        NewCharacterCHAProfToggleButton = findViewById(R.id.CharismaProficientToggleButton);

        //Edit Texts and "next" focus
        NewCharacterNameEditText = findViewById(R.id.NewCharacterNameEditText);
        NewCharacterNameEditText.setNextFocusDownId(R.id.NewCharacterLevelEditText);
        NewCharacterLevelEditText = findViewById(R.id.NewCharacterLevelEditText);
        NewCharacterLevelEditText.setNextFocusDownId(R.id.NewCharacterArmorClassEditText);
        NewCharacterArmorClassEditText = findViewById(R.id.NewCharacterArmorClassEditText);
        NewCharacterArmorClassEditText.setNextFocusDownId(R.id.NewCharacterMaxHitPointsEditText);
        NewCharacterMaxHitPointsEditText = findViewById(R.id.NewCharacterMaxHitPointsEditText);
        NewCharacterMaxHitPointsEditText.setNextFocusDownId(R.id.NewCharacterStrengthEditText);
        NewCharacterStrengthEditText = findViewById(R.id.NewCharacterStrengthEditText);
        NewCharacterStrengthEditText.setNextFocusDownId(R.id.NewCharacterDexterityEditText);
        NewCharacterDexterityEditText = findViewById(R.id.NewCharacterDexterityEditText);
        NewCharacterDexterityEditText.setNextFocusDownId(R.id.NewCharacterConstitutionEditText);
        NewCharacterConstitutionEditText = findViewById(R.id.NewCharacterConstitutionEditText);
        NewCharacterConstitutionEditText.setNextFocusDownId(R.id.NewCharacterIntelligenceEditText);
        NewCharacterIntelligenceEditText = findViewById(R.id.NewCharacterIntelligenceEditText);
        NewCharacterIntelligenceEditText.setNextFocusDownId(R.id.NewCharacterWisdomEditText);
        NewCharacterWisdomEditText = findViewById(R.id.NewCharacterWisdomEditText);
        NewCharacterWisdomEditText.setNextFocusDownId(R.id.NewCharacterCharismaEditText);
        NewCharacterCharismaEditText = findViewById(R.id.NewCharacterCharismaEditText);
        NewCharacterCharismaEditText.setNextFocusDownId(R.id.AddCharacterButton);

        AddCharacterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(newClass == "Select Class"){
                    Toast.makeText(getApplicationContext(),"Please Select a Class",Toast.LENGTH_SHORT).show();
                }
                //attempt to read in data and send it to toast
                else{
                    final String newName = NewCharacterNameEditText.getText().toString();
                    String newLevelstring = NewCharacterLevelEditText.getText().toString();
                    String newACstring = NewCharacterArmorClassEditText.getText().toString();
                    String newMaxHPstring = NewCharacterMaxHitPointsEditText.getText().toString();
                    String newSTRstring = NewCharacterStrengthEditText.getText().toString();
                    String newDEXstring = NewCharacterDexterityEditText.getText().toString();
                    String newCONstring = NewCharacterConstitutionEditText.getText().toString();
                    String newINTstring = NewCharacterIntelligenceEditText.getText().toString();
                    String newWISstring = NewCharacterWisdomEditText.getText().toString();
                    String newCHAstring = NewCharacterCharismaEditText.getText().toString();

                    //if any fields are empty, toast "Missing required parameter
                    if(
                            (newName.length() == 0)||
                                    (newLevelstring.length()==0)||
                                    (newACstring.length()==0)||
                                    (newMaxHPstring.length()==0)||
                                    (newSTRstring.length()==0)||
                                    (newDEXstring.length()==0)||
                                    (newCONstring.length()==0)||
                                    (newINTstring.length()==0)||
                                    (newWISstring.length()==0)||
                                    (newCHAstring.length()==0)
                    ){
                        Toast.makeText(getApplicationContext(),"Missing Parameter. Please check your data.",Toast.LENGTH_SHORT).show();
                    } else {

                        final int newAC = Integer.parseInt(newACstring);
                        final int newLevel = Integer.parseInt(newLevelstring);
                        final int newMaxHP = Integer.parseInt(newMaxHPstring);
                        final int newSTR = Integer.parseInt(newSTRstring);
                        final int newDEX = Integer.parseInt(newDEXstring);
                        final int newCON = Integer.parseInt(newCONstring);
                        final int newINT = Integer.parseInt(newINTstring);
                        final int newWIS = Integer.parseInt(newWISstring);
                        final int newCHA = Integer.parseInt(newCHAstring);

                        //Set Modifiers
                        final int STRMod = (newSTR - 10)/2;
                        final int DEXMod = (newDEX - 10)/2;
                        final int CONMod = (newCON - 10)/2;
                        final int INTMod = (newINT - 10)/2;
                        final int WISMod = (newWIS - 10)/2;
                        final int CHAMod = (newCHA - 10)/2;

                        //convert level to proficiency bonus
                        int ProficiencyBonus = ((newLevel -1) / 4) + 2;
                        //figure out if proficiency buttons are pressed
                        int STRSave = STRMod;
                        int DEXSave = DEXMod;
                        int CONSave = DEXMod;
                        int INTSave = INTMod;
                        int WISSave = WISMod;
                        int CHASave = CHAMod;
                        if(NewCharacterSTRProfToggleButton.isChecked()){STRSave += ProficiencyBonus;}
                        if(NewCharacterDEXProfToggleButton.isChecked()){DEXSave += ProficiencyBonus;}
                        if(NewCharacterCONProfToggleButton.isChecked()){CONSave += ProficiencyBonus;}
                        if(NewCharacterINTProfToggleButton.isChecked()){INTSave += ProficiencyBonus;}
                        if(NewCharacterWISProfToggleButton.isChecked()){WISSave += ProficiencyBonus;}
                        if(NewCharacterCHAProfToggleButton.isChecked()){CHASave += ProficiencyBonus;}

                        //Create alertdialog,
                        AlertDialog.Builder Builder = new AlertDialog.Builder(InitiativeTrackerIntroActivity.this);
                        final int finalSTRSave = STRSave;
                        final int finalDEXSave = DEXSave;
                        final int finalCONSave = CONSave;
                        final int finalINTSave = INTSave;
                        final int finalWISSave = WISSave;
                        final int finalCHASave = CHASave;
                        Builder
                                .setTitle("Add Player Character")
                                .setMessage(
                                        "Adding Character with the following information: " + "\n\n" +
                                                "Name: " + newName + "\n" +
                                                "Level: " + newLevel + "\n" +
                                                "Class: " + newClass + "\n" +
                                                "Armor Class: " + newAC +"\n" +
                                                "Max Hit Points: " + newMaxHP +"\n" +
                                                "Strength: " + newSTR + "[" +STRMod + "]  Save: [" + STRSave + "]" +"\n" +
                                                "Dexterity: " + newDEX +"[" +DEXMod + "]  Save: [" + DEXSave + "]" +"\n" +
                                                "Constitution: " + newCON +"[" +CONMod + "]  Save: [" + CONSave + "]" +"\n" +
                                                "Intelligence: " + newINT +"[" +INTMod + "]  Save: [" + INTSave + "]" +"\n" +
                                                "Wisdom: " + newWIS +"[" +WISMod + "]  Save: [" + WISSave + "]" +"\n" +
                                                "Charisma: " + newCHA +"[" +CHAMod + "]  Save: [" + CHASave + "]"
                                )
                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener(){
                                    public void onClick(DialogInterface dialog, int which) {
/**/                                    //Pass all necessary data (Excluding modifiers) to arraylist
                                        PartyArrayList.add(new CharacterEntry(newName, newLevel, newClass, newAC, newMaxHP, newMaxHP, 0, newSTR, finalSTRSave, newDEX, finalDEXSave, newCON, finalCONSave, newINT, finalINTSave, newWIS, finalWISSave, newCHA, finalCHASave));
                                        Toast.makeText(getApplicationContext(),newName + " added!",Toast.LENGTH_SHORT).show();
                                        ClearAllFields();
                                    }
                                })
                                .setNegativeButton(android.R.string.no, null)
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .show();
                    }
                }
                //End of AddCharButton OnClickListener
            }
        });

        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InitiativeTrackerIntroActivity.this, InitiativeTrackerActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("PARTY_ARRAY_LIST", PartyArrayList);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });




    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        newClass = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

//    @Override
    public void ClearAllFields(){
        ((EditText)findViewById(R.id.NewCharacterNameEditText)).getText().clear();
        ((EditText)findViewById(R.id.NewCharacterLevelEditText)).getText().clear();
        ((EditText)findViewById(R.id.NewCharacterArmorClassEditText)).getText().clear();
        ((EditText)findViewById(R.id.NewCharacterMaxHitPointsEditText)).getText().clear();
        ((EditText)findViewById(R.id.NewCharacterStrengthEditText)).getText().clear();
        ((EditText)findViewById(R.id.NewCharacterDexterityEditText)).getText().clear();
        ((EditText)findViewById(R.id.NewCharacterConstitutionEditText)).getText().clear();
        ((EditText)findViewById(R.id.NewCharacterIntelligenceEditText)).getText().clear();
        ((EditText)findViewById(R.id.NewCharacterWisdomEditText)).getText().clear();
        ((EditText)findViewById(R.id.NewCharacterCharismaEditText)).getText().clear();
        CharacterClassSpinner.setSelection(0);
        NewCharacterSTRProfToggleButton.setChecked(false);
        NewCharacterDEXProfToggleButton.setChecked(false);
        NewCharacterCONProfToggleButton.setChecked(false);
        NewCharacterINTProfToggleButton.setChecked(false);
        NewCharacterWISProfToggleButton.setChecked(false);
        NewCharacterCHAProfToggleButton.setChecked(false);

    }
}
