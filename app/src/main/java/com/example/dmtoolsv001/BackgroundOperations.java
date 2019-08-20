package com.example.dmtoolsv001;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.util.ArrayList;
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

    public ArrayList<String> InternalNPCGenerator(String race, String sex){
        //Define GeneratedNPCArrayList that will hold values to return
        ArrayList<String> GeneratedNPCArrayList = new ArrayList<>(3);
        /*
        * 0: First Name
        * 1: Last Name
        * 2: Sex
        * 3: Race
        *
        *
        *
        * */
        //Add Race and Sex to GeneratedNPCArrayList
        GeneratedNPCArrayList.set(2,sex);
        GeneratedNPCArrayList.set(3,race);

        //Create first name based on race and sex;
        switch(race){
            case "human":
                if(sex == "male"){
                    //Set first name to one of the human male names
                } else if(sex == "female"){
                    //Set first name to one of the human female names
                }

                //set last name to human last name

                break;
            case "dragonborn":
                if(sex == "male"){
                    //Set first name to one of the dragonborn male names
                } else if(sex == "female"){
                    //Set first name to one of the dragonborn female names
                }

                //set last name to dragonborn last name

                break;
            case "dwarf":

                if(sex == "male"){
                    //Set first name to one of the dwarf male names
                } else if(sex == "female"){
                    //Set first name to one of the dwarf female names
                }

                //set last name to dwarf last name

                break;
            case "elf":

                if(sex == "male"){
                    //Set first name to one of the elf male names
                } else if(sex == "female"){
                    //Set first name to one of the elf female names
                }

                //set last name to elf last name

                break;
            case "halfling":

                if(sex == "male"){
                    //Set first name to one of the halfling male names
                } else if(sex == "female"){
                    //Set first name to one of the halfling female names
                }

                //set last name to halfling last name

                break;
        }




        return GeneratedNPCArrayList;
    }


    //End BackgroundOperations Code
}
