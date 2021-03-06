package com.example.Notes.ViewModal;

import android.app.Application;
import androidx.lifecycle.LiveData;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.Notes.Modal.Notes;
import com.example.Notes.Repository.NotesRepository;

import java.util.List;


public class NotesViewModal  extends AndroidViewModel {
    public NotesRepository repository;
    public LiveData<List<Notes>> getAllNotes;
    public LiveData<List<Notes>> hightolow;
    public LiveData<List<Notes>> lowtohigh;

    public NotesViewModal(@NonNull  Application application) {

        super(application);
         repository=new NotesRepository(application);
        getAllNotes=repository.getallNotes;
        hightolow=repository.hightolow;
        lowtohigh=repository.lowtohigh;
    }

    public void insertNote(Notes  notes){
        repository.insertNotes(notes);
    }

    public void deleteNote(int id){
        repository.deleteNotes(id);
    }

    public  void updateNote(Notes  notes){
        repository.updateNotes(notes);
    }
}
