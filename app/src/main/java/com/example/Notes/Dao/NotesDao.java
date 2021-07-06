package com.example.Notes.Dao;

import androidx.lifecycle.LiveData;

import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.Notes.Modal.Notes;

import java.util.List;

@androidx.room.Dao
//Dao ke andar hm data lete hai
public interface NotesDao {

    @Query("SELECT * FROM NOTES_DATABASE")
    LiveData<List<Notes>> getallNotes();

    @Query("SELECT * FROM NOTES_DATABASE  ORDER  BY notes_priority DESC")
    LiveData<List<Notes>> highToLow();

    @Query("SELECT * FROM NOTES_DATABASE  ORDER  BY notes_priority ASC")
    LiveData<List<Notes>> LowToHigh();



    @Insert
    void insertNotes(Notes... notes);

    @Query( "DELETE FROM Notes_Database WHERE id=:id")
    void deleteNotes(int id);

    @Update
    void updateNotes(Notes notes);
}
