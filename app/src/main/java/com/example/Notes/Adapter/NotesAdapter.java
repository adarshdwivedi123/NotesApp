package com.example.Notes.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Notes.MainActivity;
import com.example.Notes.Modal.Notes;
import com.example.Notes.R;

import java.util.List;

public class NotesAdapter  extends RecyclerView.Adapter<NotesAdapter.notesViewholder>{
    MainActivity mainActivity;
    List<Notes> notes;
    public NotesAdapter(MainActivity mainActivity, List<Notes> notes) {
        this.mainActivity=mainActivity;
        this.notes=notes;
    }

    @NonNull
    @Override
    public notesViewholder onCreateViewHolder( ViewGroup parent, int viewType) {

        return new notesViewholder(LayoutInflater.from(mainActivity).inflate(R.layout.item_notes,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull  NotesAdapter.notesViewholder holder, int position) {
        

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class notesViewholder extends RecyclerView.ViewHolder {
            public notesViewholder(@NonNull  View itemView) {
                super(itemView);
            }
        }
}
