package com.example.projectlogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
public class DatabaseHelperL extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseHelper";

    private static final String TABLE_NAME = "book";
    private static final String COL1 = "ID";
    private static final String COL2 = "CID";
    private static final String COL3 = "bname";
    private static final String COL4 = "suject";
    private static final String COL5 = "author";
    private static final String COL6 = "category";

    public DatabaseHelperL(Context context) {
        super(context, TABLE_NAME, null, 1);
    }
    /*   @Override
       public void onCreate(SQLiteDatabase db) {
           String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                   COL2 +" TEXT, " +
                   COL3 +" TEXT, " +
                   COL4 +" TEXT," +
                   COL5 +" TEXT)";
           db.execSQL(createTable);
       }*/
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 +" TEXT, " +
                COL3 +" TEXT, " +
                COL4 +" TEXT," +
                COL5 +" TEXT,"+
                COL6 +" TEXT)";
        db.execSQL(createTable);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public boolean addData(String Cid,String name,String email,String phone, String pass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, Cid);
        contentValues.put(COL3, name);
        contentValues.put(COL4, email);
        contentValues.put(COL5, phone);
        contentValues.put(COL6, pass);

        //Log.d(TAG, "addData: Adding " + item + " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    /**
     * Returns all the data from database
     * @return
     */
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }
    /*Update1*/
    public Cursor getIndData(int id){
        SQLiteDatabase db = this.getWritableDatabase();

        //Cursor data = db.rawQuery(query,null);
        Cursor data = db.rawQuery("Select * from ttt where ID=" + id + "", null);
        return data;

    }
    public Cursor getCatData(String category){
        SQLiteDatabase db = this.getWritableDatabase();

        //Cursor data = db.rawQuery(query,null);
        Cursor data = db.rawQuery("Select * from book where category=" + category + "", null);
        return data;

    }
    /*Update2 src*/
    public void updateSrc(int id, String src){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL2 +
                " = '" + src + "' WHERE " + COL1 + " = '" + id + "'";
        db.execSQL(query);
    }
    /*Update3 des*/
    public void updateDes(int id, String des){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL3 +
                " = '" + des + "' WHERE " + COL1 + " = '" + id + "'";
        db.execSQL(query);
    }
    /*Update4 arr*/
    public void updateArr(int id, String arr){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL4 +
                " = '" + arr+ "' WHERE " + COL1 + " = '" + id + "'";
        db.execSQL(query);
    }
    /*Update5 dep*/
    public void updateDep(int id, String dep){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL5 +
                " = '" + dep + "' WHERE " + COL1 + " = '" + id + "'";
        db.execSQL(query);
    }









    public Cursor getItemID(String source,String destination){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL1 + " FROM " + TABLE_NAME +
                " WHERE " + COL2 + " = '" + source + "'"+ " AND " + COL3 + " = '" + destination + "'" ;
        Cursor data = db.rawQuery(query, null);
        return data;
    }
    public void updateName(String newName, int id, String oldName){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL2 +
                " = '" + newName + "' WHERE " + COL1 + " = '" + id + "'" +
                " AND " + COL2 + " = '" + oldName + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting name to " + newName);
        db.execSQL(query);
    }
    public void deleteName(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE "
                + COL1 + " = '" + id + "'";
        Log.d(TAG, "deleteName: query: " + query);
        // Log.d(TAG, "deleteName: Deleting " + name + " from database.");
        db.execSQL(query);
    }
}
