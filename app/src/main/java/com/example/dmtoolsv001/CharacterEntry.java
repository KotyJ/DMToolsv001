package com.example.dmtoolsv001;

import android.os.Parcel;
import android.os.Parcelable;

public class CharacterEntry implements Parcelable {

    //declare class-wide variables
    String Name;
    int Level;
    String CharacterClass;
    int ArmorClass;
    int MaxHP;
    int TempHP;
    int CurrentHP;
    int STRScore;
    int STRSave;
    int DEXScore;
    int DEXSave;
    int CONScore;
    int CONSave;
    int INTScore;
    int INTSave;
    int WISScore;
    int WISSave;
    int CHAScore;
    int CHASave;




    public CharacterEntry(String Name, int Level, String CharacterClass, int ArmorClass, int MaxHP, int CurrentHP, int TempHP, int STRScore, int STRSave, int DEXScore, int DEXSave, int CONScore, int CONSave, int INTScore, int INTSave, int WISScore, int WISSave, int CHAScore, int CHASave){
        this.Name = Name;
        this.Level = Level;
        this.CharacterClass = CharacterClass;
        this.ArmorClass = ArmorClass;
        this.MaxHP = MaxHP;
        this.CurrentHP = CurrentHP;
        this.TempHP = TempHP;
        this.STRScore = STRScore;
        this.STRSave = STRSave;
        this.DEXScore = DEXScore;
        this.DEXSave = DEXSave;
        this.CONScore = CONScore;
        this.CONSave = CONSave;
        this.INTScore = INTScore;
        this.INTSave = INTSave;
        this.WISScore = WISScore;
        this.WISSave = WISSave;
        this.CHAScore = CHAScore;
        this.CHASave = CHASave;
    }

    public CharacterEntry(Parcel parcel){
        this.Name = parcel.readString();
        this.Level = parcel.readInt();
        this.CharacterClass = parcel.readString();
        this.ArmorClass = parcel.readInt();
        this.MaxHP = parcel.readInt();
        this.CurrentHP = parcel.readInt();
        this.TempHP = parcel.readInt();
        this.STRScore = parcel.readInt();
        this.STRSave = parcel.readInt();
        this.DEXScore = parcel.readInt();
        this.DEXSave = parcel.readInt();
        this.CONScore = parcel.readInt();
        this.CONSave = parcel.readInt();
        this.INTScore = parcel.readInt();
        this.INTSave = parcel.readInt();
        this.WISScore = parcel.readInt();
        this.WISSave = parcel.readInt();
        this.CHAScore = parcel.readInt();
        this.CHASave = parcel.readInt();
    }

    public int getHealth(){return CurrentHP;}
    public String getName(){return Name;}
    public int getLevel(){return Level;}
    public String getCharacterClass(){return CharacterClass;}
    public int getArmorClass(){return ArmorClass;}
    public int getCurrentHP(){return CurrentHP;}
    public int getCurrentTempHP(){return TempHP;}
    public int getMaxHP(){return MaxHP;}
    public int getSTRScore(){return STRScore;}
    public int getSTRSave(){return STRSave;}
    public int getDEXScore(){return DEXScore;}
    public int getDEXSave(){return DEXSave;}
    public int getCONScore(){return CONScore;}
    public int getCONSave(){return CONSave;}
    public int getINTScore(){return INTScore;}
    public int getINTSave(){return INTSave;}
    public int getWISScore(){return WISScore;}
    public int getWISSave(){return WISSave;}
    public int getCHAScore(){return CHAScore;}
    public int getCHASave(){return CHASave;}

    public void changeHealth(int change /*Positive modifier means healing; negative modifier means damage*/){
        if(/*Taking Damage*/change <= 0){
            /*check if has temp hp.*/
            if(/*Has TempHP*/TempHP >0){/*Check if change is less than temp hp*/
                if(/*More damage than temp HP*/change >= TempHP){
                    int remainder = change - TempHP;
                    TempHP = 0;
                    CurrentHP -= remainder;
                } else{ /*less damage than tempHP*/
                    TempHP -= change;
                }
            }
        } else{ /*healing*/
            /*Healing cannot restore to above max hp*/
            CurrentHP += change;
            if(CurrentHP > MaxHP){
                CurrentHP = MaxHP;
            }
        }
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Name);
        dest.writeInt(this.Level);
        dest.writeString(this.CharacterClass);
        dest.writeInt(this.ArmorClass);
        dest.writeInt(this.MaxHP);
        dest.writeInt(this.TempHP);
        dest.writeInt(this.CurrentHP);
        dest.writeInt(this.STRScore);
        dest.writeInt(this.STRSave);
        dest.writeInt(this.DEXScore);
        dest.writeInt(this.DEXSave);
        dest.writeInt(this.CONScore);
        dest.writeInt(this.CONSave);
        dest.writeInt(this.INTScore);
        dest.writeInt(this.INTSave);
        dest.writeInt(this.WISScore);
        dest.writeInt(this.WISSave);
        dest.writeInt(this.CHAScore);
        dest.writeInt(this.CHASave);
    }

    public static final Creator<CharacterEntry> CREATOR = new Creator<CharacterEntry>(){

        public CharacterEntry createFromParcel(Parcel source) {
            return new CharacterEntry(source);
        }

        public CharacterEntry[] newArray(int size) {
            return new CharacterEntry[size];
        }
    };
}
