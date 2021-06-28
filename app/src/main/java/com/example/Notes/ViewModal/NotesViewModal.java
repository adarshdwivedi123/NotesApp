package com.example.Notes.ViewModal;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.Notes.Modal.Notes;
import com.example.Notes.Repository.NotesRepository;

import java.util.List;


public class NotesViewModal  extends AndroidViewModel {
    public NotesRepository repository;
    public LiveData<List<Notes>> getAllNotes;
    public NotesViewModal(@NonNull  Application application) {

        super(application);
         repository=new NotesRepository(application);
        getAllNotes=repository.getallNotes;
    }

    void insertNote(Notes  notes){
        repository.insertNotes(notes);
    }

    void deleteNote(int id){
        repository.deleteNotes(id);
    }

    void updateNote(Notes  notes){
        repository.updateNotes(notes);
    }
}
