package com.example.dmtoolsv001;

import java.util.Random;



class BackgroundOperations {
    //Begin Writing Code for BackgroundOperations
    int[] InternalDiceRoller(int quantity, int size, int[] results){
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
