package com.landepatil.vishal.sqlitebuilder;

import android.database.sqlite.SQLiteDatabase;


import com.landepatil.vishal.sqlitebuilder.annotations.DEFAULT;
import com.landepatil.vishal.sqlitebuilder.annotations.NotNull;
import com.landepatil.vishal.sqlitebuilder.annotations.PrimaryKey;
import com.landepatil.vishal.sqlitebuilder.annotations.Unique;

import java.lang.reflect.Field;


public class TableFactory
{

    public static String createTable(Class table, SQLiteDatabase database)
    {

        String tableName = table.getSimpleName();
        String coloumns = "", primarykeys = "";
        Field[] fields = table.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];
            if (java.lang.reflect.Modifier.isStatic(f.getModifiers())) {

            } else {
                if (!coloumns.equalsIgnoreCase("")) {
                    coloumns = coloumns + "," + f.getName();
                } else {
                    coloumns = coloumns + " " + f.getName();
                }
                if (f.getType() == (int.class)) {
                    coloumns = coloumns + " INTEGER";

                } else if (f.getType() == (short.class)) {
                    coloumns = coloumns + " INTEGER";
                } else if (f.getType() == (long.class)) {
                    coloumns = coloumns + " INTEGER";
                } else if (f.getType() == (float.class)) {
                    coloumns = coloumns + " REAL";
                } else if (f.getType() == (double.class)) {
                    coloumns = coloumns + " REAL";
                } else if (f.getType() == (boolean.class)) {
                    coloumns = coloumns + " INTEGER";
                } else if (f.getType() == (byte.class)) {
                    coloumns = coloumns + " BLOB";
                } else if (f.getType() == (char.class)) {
                    coloumns = coloumns + " TEXT";
                } else {
                    coloumns = coloumns + " TEXT";
                }
                Unique anotations = f.getAnnotation(Unique.class);
                if (anotations != null)
                    coloumns = coloumns + " " + anotations.value();
                NotNull anotationsnotnull = f.getAnnotation(NotNull.class);
                if (anotationsnotnull != null)
                   coloumns = coloumns + " " + anotationsnotnull.value();
                DEFAULT anotationsdefoult = f.getAnnotation(DEFAULT.class);
                if (anotationsdefoult != null)
                    coloumns = coloumns + " " + anotationsdefoult.annotationType().getName() + " " + anotationsdefoult.value();
                PrimaryKey anotationsPrimaryKey = f.getAnnotation(PrimaryKey.class);
                if (anotationsPrimaryKey != null) {
                    if (primarykeys.trim() == "") {
                        primarykeys = primarykeys + " " + f.getName();
                    } else {
                        primarykeys = primarykeys + "," + f.getName();
                    }
                }
            }

           /* Unique anotations =f.getAnnotation(Unique.class);
            if(anotations!=null)
            coloumns = coloumns+" "+anotations.value();*/

       }
       if (primarykeys.trim() != "") {
            coloumns = coloumns + ",PRIMARY KEY(" + primarykeys + ")";
        }

        String Query = "CREATE TABLE  IF NOT EXISTS " + tableName + " (" + coloumns + ");";


        //  Query= Query+"PRIMARY KEY("+primarykeys+")";

        database.execSQL(Query);
        return Query;
    }
    public static String dropTable(Class table)
    {

        String query = "DROP TABLE IF EXISTS " + table.getName() + ";";
        return query;
    }

}
