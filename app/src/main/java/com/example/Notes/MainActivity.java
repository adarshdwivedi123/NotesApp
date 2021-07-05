package com.example.Notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.Notes.Activity.InsertNotesActivity;
import com.example.Notes.Adapter.NotesAdapter;
import com.example.Notes.ViewModal.NotesViewModal;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
        FloatingActionButton newNotesBtn;
        NotesViewModal notesViewModal;
        RecyclerView notesRecylerview;
        NotesAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                newNotesBtn=findViewById(R.id.newNodeBtn);
        notesViewModal= ViewModelProviders.of(this).get(NotesViewModal.class);

                notesRecylerview=findViewById(R.id.notesReclerView);



                newNotesBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, InsertNotesActivity.class));
                    }
                });
                notesViewModal.getAllNotes.observe(this,notes -> {

                    notesRecylerview.setLayoutManager(new GridLayoutManager(this,2));
                    adapter=new NotesAdapter(MainActivity.this,notes);
                    notesRecylerview.setAdapter(adapter);
                });
    }
}