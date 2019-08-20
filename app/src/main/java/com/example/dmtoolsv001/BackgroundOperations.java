package com.example.dmtoolsv001;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.util.ArrayList;
import java.util.List;
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

    public SpellEntry GetSpellMethod(int UserInputLevel, String UserInputSchoolOfMagic, String UserInputCharacterClass){
        //Create SpellEntry ListArray
        List<SpellEntry> FullSpellList = new ArrayList<SpellEntry>();


        //This is the list of all available spells
        FullSpellList.add(new SpellEntry(0,"Abi-Dalzim's Horrid Wilting", "Necromancy", new String[]{}));

        return RandomSpellGeneratorMethod(FullSpellList, UserInputLevel, UserInputSchoolOfMagic, UserInputCharacterClass);

    }

    public static SpellEntry RandomSpellGeneratorMethod(List<SpellEntry> spells, int UserInputLevel, String UserInputSchoolOfMagic, String UserInputCharacterClass){

        //Make an array of Spells as Big as the List
        SpellEntry spell_arr[] = new SpellEntry[spells.size()];
        int NumberOfFoundSpells = 0; // used to count how many spells we found

        //Iterate over the List and Check for the Matching criteria
        for (int i = 0; i < spells.size(); i++) {
            if ((spells.get(i).getLevel() == UserInputLevel) && ((spells.get(i).hasClass(UserInputCharacterClass) || UserInputCharacterClass.equalsIgnoreCase("any"))) && ((spells.get(i).getSchoolOfMagic().equalsIgnoreCase(UserInputSchoolOfMagic)) || UserInputSchoolOfMagic.equalsIgnoreCase("any"))) {
                spell_arr[i] = spells.get(i);
                NumberOfFoundSpells++;
            }
        }

        //No spells could be found, sad
        if (NumberOfFoundSpells == 0) {
            System.out.println("No spells could be found");
            return null;
        }


        //Put all the found spells in a new Array
        SpellEntry finalArr[] = new SpellEntry[NumberOfFoundSpells];
        NumberOfFoundSpells = 0; //Now we use it to keep track of where in the final array we are
        for (int i = 0; i < spell_arr.length; i++) {
            if (spell_arr[i] != null) {
                finalArr[NumberOfFoundSpells] = spell_arr[i];
                NumberOfFoundSpells++;
            }
        }


        Random random = new Random();
        //Returns an random Spell Object
        return finalArr[random.nextInt(NumberOfFoundSpells)];




    }


    //End BackgroundOperations Code
}
