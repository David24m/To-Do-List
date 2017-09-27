package com.example.user.todolist;

//package com.example.user.todolist;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
///**
// * Created by user on 24/09/2017.
// */
//
public class DatabaseHelper {




 }
//
//
// extends SQLiteOpenHelper {
//
//    public static final String DATABASE_NAME = "todolist.db";
//    public static final String TABLE_NAME = "todolist_table";
//    public static final String COL1 = "ID";
//    public static final String COL2 = "TITLE";
//    public static final String COL3 = "DETAILS";
//    public static final String COL4 = "PRIORITY";
//    public static final String COL5 = "DATE";
//
//
//    public DatabaseHelper(Context context) {
//        super(context, DATABASE_NAME, null, 1);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                " TITLE TEXT, DETAILS TEXT, PRIORITY INTEGER, DATE TEXT)";
//        db.execSQL(createTable);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
//        onCreate(db);
//    }
//
//    public boolean addData(String title, String details, Integer priority, String date) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COL2, title);
//        contentValues.put(COL3, details);
//        contentValues.put(COL4, priority);
//        contentValues.put(COL5, date);
//
//        long result = db.insert(TABLE_NAME, null, contentValues);
//
//        if (result == -1) {
//            return false;
//        }else{
//            return true;
//        }
//    }
//}
