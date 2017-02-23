package com.losplomos.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by bryanesteban on 6/19/16.
 */
public final class DataBase {

    public DataBase(ffmiFragment ffmiFragment) {
    }

    public abstract class resultsEntry implements BaseColumns {

        public static final String TABLE_NAME = "Results";
        public static final String COLUMN_NAME_RESULTS_ID = "Resultid";
        public static final String COLUMN_NAME_WEIGHT = "Weight";
        public static final String COLUMN_NAME_HEIGHTFT = "Height Feet";
        public static final String COLUMN_NAME_HEIGHIN = "Height inches";
        public static final String COLUMN_NAME_LEANMASS = "Lean mass";
        public static final String COLUMN_NAME_FFMI = "FFMI";
        public static final String COLUMN_NAME_BODYFAT = "Body fat";
        private static final String TEXT_TYPE = "TEXT";
        private static final String COMMA_SEP = ",";
        private static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE" + TABLE_NAME + "(" + _ID + "INTEGER PRIMARY KEY," + COLUMN_NAME_RESULTS_ID +
                        TEXT_TYPE + COMMA_SEP + COLUMN_NAME_BODYFAT + TEXT_TYPE + COMMA_SEP + COLUMN_NAME_FFMI + TEXT_TYPE +
                        COMMA_SEP + COLUMN_NAME_HEIGHIN + TEXT_TYPE + COMMA_SEP + COLUMN_NAME_HEIGHTFT + TEXT_TYPE + COMMA_SEP
                        + COLUMN_NAME_WEIGHT + TEXT_TYPE + COMMA_SEP + COLUMN_NAME_LEANMASS + TEXT_TYPE + ")";

        private static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS" + TABLE_NAME;

        public class resultsEntryDbHelper extends SQLiteOpenHelper {
            // If You Change The Database Schema, You Must Increment The Database Version.
            public static final int DATABASE_VERSION = 1;
            public static final String DATABASE_NAME = "FeedReader.Db";

            public resultsEntryDbHelper(Context Context) {
                super(Context, DATABASE_NAME, null, DATABASE_VERSION);
            }

            public void onCreate(SQLiteDatabase db) {
                db.execSQL(SQL_CREATE_ENTRIES);
            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            }

            public void OnUpgrade(SQLiteDatabase db, int OldVersion, int newVersion) {
                // This Database Is Only A Cache For Data Online, So Its Upgrade Policy Is
                // To Simply To Discard The Data And Start Over
                db.execSQL(SQL_DELETE_ENTRIES);
                onCreate(db);
            }

            public void OnDowngrade(SQLiteDatabase db, int OldVersion, int newVersion) {
                OnUpgrade(db, OldVersion, newVersion);

            }


        }


    }

}