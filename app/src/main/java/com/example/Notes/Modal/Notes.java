package com.example.Notes.Modal;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

@androidx.room.Entity(tableName = "Notes_Database")
public class Notes {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name="notes_title")
    public String notesTitle;


    @ColumnInfo(name="notes_Subtitle")
    public String notesSubTitle;

    @ColumnInfo(name="notes_date")
    public String notesDate;

    @ColumnInfo(name="notes")
    public String notes;

    @ColumnInfo(name="notes_priority")
    public String notesPriority;



}
