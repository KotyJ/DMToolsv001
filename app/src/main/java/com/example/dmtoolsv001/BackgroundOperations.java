package com.example.dmtoolsv001;

import java.util.Random;

public class BackgroundOperations {
    //Begin Writing Code for BackgroundOperations
    public int InternalDiceRoller(int quantity, int size){
        int total = 0;
            for(int i = 0; i < quantity; i++){
                int roll = new Random().nextInt(size)+1;
                total += roll;
            }
        return total;
    }



    //End BackgroundOperations Code
}
