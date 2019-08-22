package com.example.dmtoolsv001;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class RandomSpellActivity extends AppCompatActivity {

    BackgroundOperationsRandomSpell BGO = new BackgroundOperationsRandomSpell();

    RadioGroup LevelSelectRadioGroup;
    RadioGroup ClassSelectRadioGroup;
    RadioGroup SchoolSelectRadioButton;
    Button GenerateButton;

    public int UserInputLevel;
    public String UserInputSchoolOfMagic;
    public String UserInputCharacterClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randomspell);
        //Initialize XML connections
        LevelSelectRadioGroup = findViewById(R.id.LevelSelectRadioGroup);
        ClassSelectRadioGroup = findViewById(R.id.ClassSelectRadioGroup);
        SchoolSelectRadioButton = findViewById(R.id.SchoolSelectRadioGroup);

        //Initialize User Input Variables
        UserInputLevel = 0;
        UserInputSchoolOfMagic = "any";
        UserInputCharacterClass = "any";
        //When Level radio button is changed, update UserInputLevel
        LevelSelectRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int CheckedButtonID) {
                if (CheckedButtonID == R.id.CantripRadioButton){
                    UserInputLevel = 0;
                } else if (CheckedButtonID == R.id.Level1RadioButton){
                    UserInputLevel = 1;
                } else if (CheckedButtonID == R.id.Level2RadioButton){
                    UserInputLevel = 2;
                }else if (CheckedButtonID == R.id.Level3RadioButton){
                    UserInputLevel = 3;
                }else if (CheckedButtonID == R.id.Level4RadioButton){
                    UserInputLevel = 4;
                }else if (CheckedButtonID == R.id.Level5RadioButton){
                    UserInputLevel = 5;
                }else if (CheckedButtonID == R.id.Level6RadioButton){
                    UserInputLevel = 6;
                }else if (CheckedButtonID == R.id.Level7RadioButton){
                    UserInputLevel = 7;
                } else if (CheckedButtonID == R.id.Level8RadioButton){
                    UserInputLevel = 8;
                }else if (CheckedButtonID == R.id.Level9RadioButton){
                    UserInputLevel = 9;
                }
            }
        });

        //When School Radio Button is changed, update UserInputSchoolOfMagic
        SchoolSelectRadioButton.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int CheckedButtonID) {
                if(CheckedButtonID == R.id.AbjurationRadioButton){
                    UserInputSchoolOfMagic = "abjuration";
                } else if(CheckedButtonID == R.id.ConjurationRadioButton){
                    UserInputSchoolOfMagic = "conjuration";
                } else if(CheckedButtonID == R.id.DivinationSelectRadioButton){
                    UserInputSchoolOfMagic = "divination";
                } else if(CheckedButtonID == R.id.EnchantmentSelectRadioButton){
                    UserInputSchoolOfMagic = "enchantment";
                } else if(CheckedButtonID == R.id.EvocationSelectRadioButton){
                    UserInputSchoolOfMagic = "evocation";
                } else if(CheckedButtonID == R.id.IllusionSelectRadioButton){
                    UserInputSchoolOfMagic = "illusion";
                } else if(CheckedButtonID == R.id.NecromancySelectRadioButton){
                    UserInputSchoolOfMagic = "necromancy";
                } else if(CheckedButtonID == R.id.TransmutationSelectRadioButton){
                    UserInputSchoolOfMagic = "transmutation";
                } else if(CheckedButtonID == R.id.AnySchoolRadioButton){
                    UserInputSchoolOfMagic = "any";
                }
            }
        });

        //Convert Class Radio Button into String
        ClassSelectRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int CheckedButtonID) {
                if(CheckedButtonID == R.id.RogueRadioButton){
                    UserInputCharacterClass = "rogue";
                } else if(CheckedButtonID == R.id.BardRadioButton){
                    UserInputCharacterClass = "bard";
                } else if(CheckedButtonID == R.id.ClericRadioButton){
                    UserInputCharacterClass = "cleric";
                } else if(CheckedButtonID == R.id.DruidRadioButton){
                    UserInputCharacterClass = "druid";
                } else if(CheckedButtonID == R.id.SorcererRadioButton){
                    UserInputCharacterClass = "sorcerer";
                } else if(CheckedButtonID == R.id.WizardRadioButton){
                    UserInputCharacterClass = "wizard";
                } else if(CheckedButtonID == R.id.FighterRadioButton){
                    UserInputCharacterClass = "fighter";
                } else if(CheckedButtonID == R.id.PaladinRadioButton){
                    UserInputCharacterClass = "paladin";
                } else if(CheckedButtonID == R.id.WarlockRadioButton){
                    UserInputCharacterClass = "warlock";
                } else if(CheckedButtonID == R.id.ArtificerRadioButton){
                    UserInputCharacterClass = "artificer";
                } else if(CheckedButtonID == R.id.AnyClassRadioButton){
                    UserInputCharacterClass = "any";
                }
            }
        });
        GenerateButton = findViewById(R.id.GenerateButton);
        GenerateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //create new spell using inputs
                SpellEntry ReturnedSpell = BGO.GetSpellMethod(RandomSpellActivity.this, UserInputLevel, UserInputSchoolOfMagic, UserInputCharacterClass);

                //check if returnedspell is null
                if(ReturnedSpell == null){
                    Toast.makeText(getApplicationContext(), "Unable to find spell matching criteria. Please try again", Toast.LENGTH_LONG).show();



                } else {

                    //initialize textviews
                    TextView ChosenSpellNameTextView = findViewById(R.id.ChosenSpellNameTextView);
                    TextView ChosenSpellLevelTextView = findViewById(R.id.ChosenSpellLevelTextView);
                    TextView ChosenSpellSchoolTextView = findViewById(R.id.ChosenSpellSchoolTextView);
                    TextView ChosenSpellClassesTextView = findViewById(R.id.ChosenSpellClassesTextView);

                    //set textviews
                    ChosenSpellNameTextView.setText(ReturnedSpell.getName());
                    ChosenSpellLevelTextView.setText(ReturnedSpell.getLevel() + "");
                    ChosenSpellSchoolTextView.setText(ReturnedSpell.getSchoolOfMagic());
                    ChosenSpellClassesTextView.setText(Arrays.toString(ReturnedSpell.getClassesAvailable()));

                }
            }
        });











    }
}
