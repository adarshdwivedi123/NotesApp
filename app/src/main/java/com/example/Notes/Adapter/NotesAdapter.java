package com.example.Notes.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Notes.Activity.UpdateNOtesActivity;
import com.example.Notes.MainActivity;
import com.example.Notes.Modal.Notes;
import com.example.Notes.R;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter  extends RecyclerView.Adapter<NotesAdapter.notesViewholder>{
    MainActivity mainActivity;
    List<Notes> notes;
    List<Notes>allNotesItem;

    public NotesAdapter(MainActivity mainActivity, List<Notes> notes) {
        this.mainActivity=mainActivity;
        this.notes=notes;
        allNotesItem=new ArrayList<>(notes);


    }
    public void searchNotes(List<Notes> filteredName)
    {
        this.notes=filteredName;
        notifyDataSetChanged();// notify se pta chl jata hai unke andar chnages huye hai
    }


    @NonNull
    @Override
    public notesViewholder onCreateViewHolder( ViewGroup parent, int viewType) {

        return new notesViewholder(LayoutInflater.from(mainActivity).inflate(R.layout.item_notes,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull  NotesAdapter.notesViewholder holder, int position) {

        Notes note=notes.get(position);

        switch (note.notesPriority) {
            case "1":
                holder.notesPriority.setBackgroundResource(R.drawable.green_shape);
                break;
            case "2":
                holder.notesPriority.setBackgroundResource(R.drawable.yellow_shape);
                break;
            case "3":
                holder.notesPriority.setBackgroundResource(R.drawable.red_shape);
                break;
        }


        holder.title.setText(note.notesTitle);
        holder.subtitle.setText(note.notesSubTitle);
        holder.notesDate.setText(note.notesDate);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mainActivity, UpdateNOtesActivity.class);
                intent.putExtra("id",note.id);
                intent.putExtra("title",note.notesTitle);
                intent.putExtra("subtitle",note.notesSubTitle);
                intent.putExtra("priority",note.notesPriority);
                intent.putExtra("note",note.notes);



                mainActivity.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class notesViewholder extends RecyclerView.ViewHolder {
        TextView title,subtitle,notesDate;
        View  notesPriority;

            public notesViewholder(@NonNull  View itemView) {
                super(itemView);
                title=itemView.findViewById(R.id.notesTitle);
                subtitle=itemView.findViewById(R.id.notesSubTitle);
                notesDate=itemView.findViewById(R.id.notesdate);
                notesPriority=itemView.findViewById(R.id.notespriority);


            }
        }
}
