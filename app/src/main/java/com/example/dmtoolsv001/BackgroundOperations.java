package com.example.dmtoolsv001;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.util.Random;

public class BackgroundOperations {
    //Begin Writing Code for BackgroundOperations
    public int[] InternalDiceRoller(int quantity, int size, int[] results){
        int total = 0;

        for(int i = 1; i <= quantity; i++){
                int roll = new Random().nextInt(size)+1;
                total += roll;
                results[i] = roll;
            }

        results[0] = total;
        return results;
    }






    //End BackgroundOperations Code
}
