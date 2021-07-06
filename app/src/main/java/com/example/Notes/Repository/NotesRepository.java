package com.example.Notes.Repository;

import android.app.Application;
import androidx.lifecycle.LiveData;

import com.example.Notes.Dao.NotesDao;
import com.example.Notes.Database.NotesDatabase;
import com.example.Notes.Modal.Notes;

import java.util.List;

public class NotesRepository {
    public NotesDao  notesDao;
    public LiveData<List<Notes>>getallNotes;
    public LiveData<List<Notes>>hightolow;
    public LiveData<List<Notes>>lowtohigh;

    public NotesRepository(Application application)
    {
        NotesDatabase  database=NotesDatabase.getDatabaseInstance(application);
        notesDao=database.notesDao();
        getallNotes=notesDao.getallNotes();
        hightolow=notesDao.highToLow();
        lowtohigh=notesDao.LowToHigh();

    }
  public  void insertNotes(Notes notes)
    {

        notesDao.insertNotes(notes);
    }
    public  void deleteNotes(int id)
    {

        notesDao.deleteNotes(id);
    }
    public  void updateNotes(Notes  notes)
    {
            notesDao.updateNotes(notes);
    }

}
