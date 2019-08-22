package com.example.dmtoolsv001;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PlayerCharacterDatabaseManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "PlayerCharactersDatabase";
    private static final int DATABASE_VERSION = 1;
    private static final String COLUMN_ID = "id";
    private static final String TABLE_NAME = "playercharacters";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_LEVEL = "level";
    private static final String COLUMN_CHARACTERCLASS = "characterclass";
    private static final String COLUMN_ARMORCLASS = "armorclass";
    private static final String COLUMN_MAXHITPOINTS = "maxhp";
    private static final String COLUMN_STRENGTH = "strength";
    private static final String COLUMN_DEXTERITY = "dexterity";
    private static final String COLUMN_CONSTITUTION = "constitution";
    private static final String COLUMN_INTELLIGENCE = "intelligence";
    private static final String COLUMN_WISDOM = "wisdom";
    private static final String COLUMN_CHARISMA = "charisma";

    PlayerCharacterDatabaseManager(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){

        String sql = "CREATE TABLE " + TABLE_NAME + " (\n" +
                "    " + COLUMN_ID + " INTEGER NOT NULL CONSTRAINT playercharacters_pk PRIMARY KEY AUTOINCREMENT,\n" +
                "    " + COLUMN_NAME + " varchar(200) NOT NULL ,\n" +
                "    " + COLUMN_LEVEL + " int NOT NULL,\n" +
                "    " + COLUMN_CHARACTERCLASS + " varchar(200) NOT NULL,\n" +
                "    " + COLUMN_ARMORCLASS + " int NOT NULL,\n" +
                "    " + COLUMN_MAXHITPOINTS + " int NOT NULL,\n" +
                "    " + COLUMN_STRENGTH + " int NOT NULL,\n" +
                "    " + COLUMN_DEXTERITY + " int NOT NULL,\n" +
                "    " + COLUMN_CONSTITUTION + " int NOT NULL,\n" +
                "    " + COLUMN_INTELLIGENCE + " int NOT NULL,\n" +
                "    " + COLUMN_WISDOM + " int NOT NULL,\n" +
                "    " + COLUMN_CHARISMA + " int NOT NULL\n" +
                ");";

        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        /*
         * We are doing nothing here
         * Just dropping and creating the table
         * */
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME + ";";
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

    /*
     * CREATE OPERATION
     * ====================
     * This is the first operation of the CRUD.
     * This method will create a new employee in the table
     * Method is taking all the parameters required
     *
     * Operation is very simple, we just need a content value objects
     * Inside this object we will put everything that we want to insert.
     * So each value will take the column name and the value that is to inserted
     * for the column name we are using the String variables that we defined already
     *
     * Once we have the contentValues object with all the values required
     * We will call the method getWritableDatabase() and it will return us the SQLiteDatabase object and we can write on the database using it.
     *
     * With this object we will call the insert method it takes 3 parameters
     * 1. String -> The table name where the value is to be inserted
     * 2. String -> The default values of null columns, it is null here as we don't have any default values
     * 3. ContentValues -> The values that is to be inserted
     *
     * insert() will return the inserted row id, if there is some error inserting the row
     * it will return -1
     *
     * So here we are returning != -1, it will be true if record is inserted and false if not inserted
     * */

    boolean addPlayerCharacter(int id, String name,int level, String characterclass, int armorclass, int maxhitpoints, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID, id);
        contentValues.put(COLUMN_NAME, name);
        contentValues.put(COLUMN_LEVEL, level);
        contentValues.put(COLUMN_CHARACTERCLASS, characterclass);
        contentValues.put(COLUMN_ARMORCLASS, armorclass);
        contentValues.put(COLUMN_MAXHITPOINTS, maxhitpoints);
        contentValues.put(COLUMN_STRENGTH, strength);
        contentValues.put(COLUMN_DEXTERITY, dexterity);
        contentValues.put(COLUMN_CONSTITUTION, constitution);
        contentValues.put(COLUMN_INTELLIGENCE, intelligence);
        contentValues.put(COLUMN_WISDOM, wisdom);
        contentValues.put(COLUMN_CHARISMA, charisma);

        SQLiteDatabase db = getWritableDatabase();
        return db.insert(TABLE_NAME, null, contentValues) != -1;
    }

    /*
     * READ OPERATION
     * =================
     * Here we are reading values from the database
     * First we called the getReadableDatabase() method it will return us the SQLiteDatabase instance
     * but using it we can only perform the read operations.
     *
     * We are running rawQuery() method by passing the select query.
     * rawQuery takes two parameters
     * 1. The query
     * 2. String[] -> Arguments that is to be binded -> We use it when we have a where clause in our query to bind the where value
     *
     * rawQuery returns a Cursor object having all the data fetched from database
     * */
    Cursor getAllPlayerCharacters() {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    /*
     * UPDATE OPERATION
     * ==================
     * Here we are performing the update operation. The proecess is same as the Create operation.
     * We are first getting a database instance using getWritableDatabase() method as the operation we need to perform is a write operation
     * Then we have the contentvalues object with the new values
     *
     * to update the row we use update() method. It takes 4 parameters
     * 1. String -> It is the table name
     * 2. ContentValues -> The new values
     * 3. String -> Here we pass the column name = ?, the column we want to use for putting the where clause
     * 4. String[] -> The values that is to be binded with the where clause
     * */
    boolean updatePlayerCharacter(int id, String name, int level, String characterclass, int armorclass, int maxhitpoints, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID, id);
        contentValues.put(COLUMN_NAME, name);
        contentValues.put(COLUMN_LEVEL, level);
        contentValues.put(COLUMN_CHARACTERCLASS, characterclass);
        contentValues.put(COLUMN_ARMORCLASS, armorclass);
        contentValues.put(COLUMN_MAXHITPOINTS, maxhitpoints);
        contentValues.put(COLUMN_STRENGTH, strength);
        contentValues.put(COLUMN_DEXTERITY, dexterity);
        contentValues.put(COLUMN_CONSTITUTION, constitution);
        contentValues.put(COLUMN_INTELLIGENCE, intelligence);
        contentValues.put(COLUMN_WISDOM, wisdom);
        contentValues.put(COLUMN_CHARISMA, charisma);

        return db.delete(TABLE_NAME, COLUMN_ID + "=?", new String[]{String.valueOf(id)}) == 1;
    }



}
