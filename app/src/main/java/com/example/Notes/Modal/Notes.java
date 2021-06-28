package com.example.Notes.Modal;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

@androidx.room.Entity(tableName = "Notes_Database")
public class Notes {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name="notes_title")
    String notesTitle;


    @ColumnInfo(name="notes_Subtitle")
    String notesSubTitle;

    @ColumnInfo(name="notes_date")
    String notesDate;

    @ColumnInfo(name="notes")
    String notes;

    @ColumnInfo(name="notes_priority")
    String notesPriority;



}
