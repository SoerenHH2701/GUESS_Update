package com.pigo.guess_reloaded;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class DB_Handler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "q_and_a_db";
    private static final String TABLE_QANDA = "questions_and_answers_table";
    private static final String TABLE_SEL_QA = "selected_qa_table";
    private static final String KEY_ID = "id";
    private static final String KEY_FRAGE = "frage";
    private static final String KEY_ANTWORT = "antwort";
    private static final String KEY_SCHWIERIGKEIT = "schwierigkeit";
    private static final String QA_KEY_ID = "id";
    private static final String QA_KEY_FRAGE = "frage";
    private static final String QA_KEY_ANTWORT = "antwort";
    private static final String ANTWORT_FALSCH_1 = "antwort_falsch_1";
    private static final String ANTWORT_FALSCH_2 = "antwort_falsch_2";
    private static final String ANTWORT_FALSCH_3 = "antwort_falsch_3";
    private static final String ANTWORT_FALSCH_1_QA = "antwort_falsch_1_qa";
    private static final String ANTWORT_FALSCH_2_QA = "antwort_falsch_2_qa";
    private static final String ANTWORT_FALSCH_3_QA = "antwort_falsch_3_qa";

    public DB_Handler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

            String CREATE_TABLE_QANDA = "CREATE TABLE " + TABLE_QANDA + "("
                    + KEY_ID + " INTEGER PRIMARY KEY," + KEY_FRAGE + " TEXT,"
                    + KEY_ANTWORT + " TEXT," + KEY_SCHWIERIGKEIT + " TEXT,"
                    + ANTWORT_FALSCH_1 + " TEXT," + ANTWORT_FALSCH_2 + " TEXT," + ANTWORT_FALSCH_3 + " TEXT" + ")";
            db.execSQL(CREATE_TABLE_QANDA);

            String CREATE_TABLE_SEL_QA = "CREATE TABLE " + TABLE_SEL_QA + "("
                    + QA_KEY_ID + " INTEGER PRIMARY KEY," + QA_KEY_FRAGE + " TEXT,"
                    + QA_KEY_ANTWORT + " TEXT," + ANTWORT_FALSCH_1_QA + " TEXT," + ANTWORT_FALSCH_2_QA + " TEXT,"
                    + ANTWORT_FALSCH_3_QA + " TEXT" + ")";
            db.execSQL(CREATE_TABLE_SEL_QA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_QANDA);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_SEL_QA);
            onCreate(db);
    }

    public int getSize(String questions_and_answers_table) {
        SQLiteDatabase db = this.getReadableDatabase();
        long dbSize = DatabaseUtils.queryNumEntries(db, questions_and_answers_table);
        db.close();
        return (Integer) (int) dbSize;
    }

    public int getSizeQA(String selected_qa_table) {
        SQLiteDatabase db = this.getReadableDatabase();
        long dbSize = DatabaseUtils.queryNumEntries(db, selected_qa_table);
        db.close();
        return (Integer) (int) dbSize;
    }

    // Füge alle Datensätze der Tabelle hinzu

    void addQANDA(DB_Columns_QANDA qanda) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_FRAGE, qanda.getFrage());
        values.put(KEY_ANTWORT, qanda.getAntwort());
        values.put(KEY_SCHWIERIGKEIT, qanda.getSchwierigkeit());
        values.put(ANTWORT_FALSCH_1, qanda.getAntwort_falsch_1());
        values.put(ANTWORT_FALSCH_2, qanda.getAntwort_falsch_2());
        values.put(ANTWORT_FALSCH_3, qanda.getAntwort_falsch_3());

        db.insert(TABLE_QANDA, null, values);
        db.close();
    }

    // Füge Datensätze zur Tabelle hinzu, wenn der User eine Kategorie und / oder Schwierigkeit gewählt hat

    void addSelectedQA(DB_Columns_QA qa) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(QA_KEY_FRAGE, qa.getfrageQA());
        values.put(QA_KEY_ANTWORT, qa.getantwortQA());
        values.put(ANTWORT_FALSCH_1_QA, qa.getAntwort_falsch_1_QA());
        values.put(ANTWORT_FALSCH_2_QA, qa.getAntwort_falsch_2_QA());
        values.put(ANTWORT_FALSCH_3_QA, qa.getAntwort_falsch_3_QA());

        db.insert(TABLE_SEL_QA, null, values);
        db.close();
    }

    // Gebe nur Fragen und Antworten aus, die der vom User ausgewählten Kategorie und Schwierigkeit entsprechen

    public List<DB_Columns_QANDA> getAllQANDA() {
        List<DB_Columns_QANDA> qandaList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_QANDA + " WHERE schwierigkeit = '"+Difficulty.clickedDifficulty+"' ";

        System.out.println("query: "+selectQuery);
        System.out.println("diff: "+Difficulty.clickedDifficulty);

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DB_Columns_QANDA qanda = new DB_Columns_QANDA();
                qanda.setID(Integer.parseInt(cursor.getString(0)));
                qanda.setFrage(cursor.getString(1));
                qanda.setAntwort(cursor.getString(2));
                qanda.setSchwierigkeit(cursor.getString(3));
                qanda.setAntwort_falsch_1(cursor.getString(4));
                qanda.setAntwort_falsch_2(cursor.getString(5));
                qanda.setAntwort_falsch_3(cursor.getString(6));
                // Adding contact to list
                qandaList.add(qanda);
            } while (cursor.moveToNext());
        }
        return qandaList;
    }

    // Gebe alle Fragen und Antworten aus

    public List<DB_Columns_QA> getAllQA() {
        List<DB_Columns_QA> qaList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_SEL_QA;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DB_Columns_QA qa = new DB_Columns_QA();
                qa.setIdQA(Integer.parseInt(cursor.getString(0)));
                qa.setfrageQA(cursor.getString(1));
                qa.setantwortQA(cursor.getString(2));
                qa.setAntwort_falsch_1_QA(cursor.getString(3));
                qa.setAntwort_falsch_2_QA(cursor.getString(4));
                qa.setAntwort_falsch_3_QA(cursor.getString(5));
                // Adding contact to list
                qaList.add(qa);
            } while (cursor.moveToNext());
        }
        return qaList;
    }

    public void removeAllRowsFromNewsTable(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("selected_qa_table",null,null);
    }

    public void dropTableQANDA(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QANDA);
    }

    public void createTableQANDA(){
        SQLiteDatabase db = this.getWritableDatabase();
        String CREATE_TABLE_QANDA = "CREATE TABLE " + TABLE_QANDA + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_FRAGE + " TEXT,"
                + KEY_ANTWORT + " TEXT," + KEY_SCHWIERIGKEIT + " TEXT,"
                + ANTWORT_FALSCH_1 + " TEXT," + ANTWORT_FALSCH_2 + " TEXT," + ANTWORT_FALSCH_3 + " TEXT" + ")";
        db.execSQL(CREATE_TABLE_QANDA);
    }


}
