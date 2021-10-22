package com.pigo.guess_reloaded;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
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
    private static final String QA_KEY_ID = "id";
    private static final String QA_KEY_FRAGE = "frage";
    private static final String QA_KEY_ANTWORT = "antwort";
    private static final String KEY_KATEGORIE = "kategorie";
    private static final String KEY_SCHWIERIGKEIT = "schwierigkeit";

    public DB_Handler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

            String CREATE_TABLE_QANDA = "CREATE TABLE " + TABLE_QANDA + "("
                    + KEY_ID + " INTEGER PRIMARY KEY," + KEY_FRAGE + " TEXT,"
                    + KEY_ANTWORT + " TEXT," + KEY_KATEGORIE + " TEXT," + KEY_SCHWIERIGKEIT + " TEXT" + ")";
            db.execSQL(CREATE_TABLE_QANDA);

            String CREATE_TABLE_SEL_QA = "CREATE TABLE " + TABLE_SEL_QA + "("
                    + QA_KEY_ID + " INTEGER PRIMARY KEY," + QA_KEY_FRAGE + " TEXT,"
                    + QA_KEY_ANTWORT + " TEXT" + ")";
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
        values.put(KEY_KATEGORIE, qanda.getKategorie());
        values.put(KEY_SCHWIERIGKEIT, qanda.getSchwierigkeit());

        db.insert(TABLE_QANDA, null, values);
        db.close();
    }

    // Füge Datensätze zur Tabelle hinzu, wenn der User eine Kategorie und / oder Schwierigkeit gewählt hat

    void addSelectedQA(DB_Columns_QA qa) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(QA_KEY_FRAGE, qa.getfrageQA());
        values.put(QA_KEY_ANTWORT, qa.getantwortQA());

        db.insert(TABLE_SEL_QA, null, values);
        db.close();
    }

    // Gebe nur Fragen und Antworten aus, die der vom User ausgewählten Kategorie und Schwierigkeit entsprechen

    public List<DB_Columns_QANDA> getAllQANDA() {
        List<DB_Columns_QANDA> qandaList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_QANDA + " WHERE kategorie = '"+Category.clickedKategorie+"' AND schwierigkeit = '"+Difficulty.clickedDifficulty+"' ";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DB_Columns_QANDA qanda = new DB_Columns_QANDA();
                qanda.setID(Integer.parseInt(cursor.getString(0)));
                qanda.setFrage(cursor.getString(1));
                qanda.setAntwort(cursor.getString(2));
                qanda.setKategorie(cursor.getString(3));
                qanda.setSchwierigkeit(cursor.getString(4));
                // Adding contact to list
                qandaList.add(qanda);
            } while (cursor.moveToNext());
        }
        return qandaList;
    }

    // Gebe alle Fragen und Antworten aus

    public List<DB_Columns_QA> getAllQA() {
        List<DB_Columns_QA> qaList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_SEL_QA;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                DB_Columns_QA qa = new DB_Columns_QA();
                qa.setIdQA(Integer.parseInt(cursor.getString(0)));
                qa.setfrageQA(cursor.getString(1));
                qa.setantwortQA(cursor.getString(2));
                // Adding contact to list
                qaList.add(qa);
            } while (cursor.moveToNext());
        }
        return qaList;
    }


}
