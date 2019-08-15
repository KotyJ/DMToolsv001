package com.example.dmtoolsv001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Arrays;

public class DiceRollerActivity extends AppCompatActivity {

    int DieSize;
    int Quantity;
    int Modifier;
    int Total;
    EditText StaticModifierEditText;
    EditText DiceToRollEditText;
    TextView TotalTextView;
    TextView ResultsTextView;
    Button D4Button;
    Button D6Button;
    Button D8Button;
    Button D10Button;
    Button D12Button;
    Button D20Button;
    Button D100Button;
    Button RollDiceButton;


    //Initiate DieRoller
    BackgroundOperations BGO = new BackgroundOperations();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roller);

        Quantity = 0;
        Modifier = 0;
        Total = 0;
        DieSize = 20;

        //get text info from XML to Java
        DiceToRollEditText = findViewById(R.id.DiceToRollEditText);
        StaticModifierEditText = findViewById(R.id.StaticModifierEditText);
        D4Button = findViewById(R.id.d4Button);
        D6Button = findViewById(R.id.d6Button);
        D8Button = findViewById(R.id.d8Button);
        D10Button = findViewById(R.id.d10Button);
        D12Button = findViewById(R.id.d12Button);
        D20Button = findViewById(R.id.d20Button);
        D100Button = findViewById(R.id.d100Button);
        RollDiceButton = findViewById(R.id.RollDiceButton);
        TotalTextView = findViewById(R.id.TotalTextView);
        ResultsTextView = findViewById(R.id.ResultsTextView);

        //Process data
        D4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateDieSize(4);
            }
        });
        D6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateDieSize(6);

            }
        });
        D8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateDieSize(8);
            }
        });
        D10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateDieSize(10);
            }
        });
        D12Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateDieSize(12);
            }
        });
        D20Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateDieSize(20);
            }
        });
        D100Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateDieSize(100);
            }
        });

        RollDiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeKeyboard();
                //If DiceToRollEditText is empty, treat it as 1
                if(DiceToRollEditText.getText().toString().trim().length() == 0){
                    Quantity = 1;
                }
                else {
                    Quantity = Integer.parseInt(DiceToRollEditText.getText().toString());
                }
                //If StaticModifierEditText is empty, treat it as 0
                if(StaticModifierEditText.getText().toString().trim().length() == 0){
                    Modifier = 0;
                }else{
                    Modifier = Integer.parseInt(StaticModifierEditText.getText().toString());
                }

                int[] ResultsWithTotal = new int[Quantity + 1];
                int[] ResultsNoTotal = new int[Quantity];
                ResultsWithTotal = BGO.InternalDiceRoller(Quantity,DieSize,ResultsWithTotal);

                for(int i = 0; i < Quantity; i++){
                    ResultsNoTotal[i] = ResultsWithTotal[i+1];
                }

                String resultsString = Arrays.toString(ResultsNoTotal);
                ResultsTextView.setText(resultsString + " +" + Modifier);

                Total = ResultsWithTotal[0] + Modifier;

                TotalTextView.setText("Total: " + Total);
            }

        });

    }

    public void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void UpdateDieSize(int NewDieSize){
        if(NewDieSize == DieSize){

        }else{
            switch(DieSize){
                case 4:
                    //paint d4 button default
                    PaintButtonGray(D4Button);
                    break;
                case 6:
                    //paint d6 button default
                    PaintButtonGray(D6Button);
                    break;
                case 8:
                    //paint d8 button default
                    PaintButtonGray(D8Button);
                    break;
                case 10:
                    //paint d10 button default
                    PaintButtonGray(D10Button);
                    break;
                case 12:
                    //paint d12 button default
                    PaintButtonGray(D12Button);
                    break;
                case 20:
                    //paint d20 button default
                    PaintButtonGray(D20Button);
                    break;
                case 100:
                    //paint d100 button default
                    PaintButtonGray(D100Button);
                    break;
            }
            switch(NewDieSize){
                case 4:
                    //paint d4 button blue
                    PaintButtonBlue(D4Button);
                    break;
                case 6:
                    //paint d6 button blue
                    PaintButtonBlue(D6Button);
                    break;
                case 8:
                    //paint d8 button blue
                    PaintButtonBlue(D8Button);
                    break;
                case 10:
                    //paint d10 button blue
                    PaintButtonBlue(D10Button);
                    break;
                case 12:
                    //paint d12 button blue
                    PaintButtonBlue(D12Button);
                    break;
                case 20:
                    //paint d20 button blue
                    PaintButtonBlue(D20Button);
                    break;
                case 100:
                    //paint d100 button blue
                    PaintButtonBlue(D100Button);
                    break;
            }
            DieSize = NewDieSize;
        }
    }

    public void PaintButtonGray(Button Button){
        Button.setBackgroundColor(getResources().getColor(R.color.gray));
        Button.setTextColor(getResources().getColor(R.color.black));
    }

    public void PaintButtonBlue(Button Button){
        Button.setBackgroundColor(getResources().getColor(R.color.blue));
        Button.setTextColor(getResources().getColor(R.color.white));
    }
}
