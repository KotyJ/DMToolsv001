package com.example.dmtoolsv001;

public class SpellEntry {

    private int SpellLevel;
    private String SpellName;
    private String[] ClassesAvailable;
    private String SchoolOfMagic;


    public SpellEntry(int SpellLevel, String SpellName, String SchoolOfMagic, String[] ClassesAvailable) {
        this.SpellLevel = SpellLevel;
        this.SpellName = SpellName;
        this.SchoolOfMagic = SchoolOfMagic;
        this.ClassesAvailable = ClassesAvailable;
    }


    public int getLevel() {
        return SpellLevel;
    }


    public String getName() {
        return SpellName;
    }

    public String getSchoolOfMagic(){
        return SchoolOfMagic;
    }

    public String[] getClassesAvailable() {
        return ClassesAvailable;
    }


    public boolean hasClass(String CharacterClass) {
        for (int i = 0; i < this.ClassesAvailable.length; i++) {
            if (this.ClassesAvailable[i].equalsIgnoreCase(CharacterClass)) {
                return true;
            }
        }
        return false;
    }

}