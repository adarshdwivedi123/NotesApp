package com.example.Notes.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

//import android.arch.lifecycle.ViewModelProviders;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Toast;

import com.example.Notes.Modal.Notes;
import com.example.Notes.R;
import com.example.Notes.ViewModal.NotesViewModal;
import com.example.Notes.databinding.ActivityInsertNotesBinding;

import java.util.Date;

public class InsertNotesActivity extends AppCompatActivity {
    ActivityInsertNotesBinding binding;
    String title,subtitle,notes;
    NotesViewModal notesViewModal;
    // if their is no priority automatically  goes to green
    String priority ="1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityInsertNotesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        notesViewModal= ViewModelProviders.of(this).get(NotesViewModal.class);
        binding.greenPriority.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.greenPriority.setImageResource(R.drawable.ic_baseline_done_24);
                binding.yellowPriority.setImageResource(0);
                binding.RedPriority.setImageResource(0);
                priority ="1";
            }
        });
        binding.yellowPriority.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.greenPriority.setImageResource(0);
                binding.yellowPriority.setImageResource(R.drawable.ic_baseline_done_24);
                binding.RedPriority.setImageResource(0);
                priority ="2";
            }
        });
        binding.RedPriority.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.greenPriority.setImageResource(0);
                binding.yellowPriority.setImageResource(0);
                binding.RedPriority.setImageResource(R.drawable.ic_baseline_done_24);
                priority ="3";

            }
        });




        binding.doneNotesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title=binding.notesTitle.getText().toString();
                subtitle=binding.notesSubTitle.getText().toString();
                notes=binding.notesData.getText().toString();
                CreateNotes(title,subtitle,notes);
            }
        });


    }

    private void CreateNotes(String title, String subtitle, String notes) {
        Date date=new Date();
        CharSequence sequence= DateFormat.format("MMMM d,yyyy",date.getTime());


        Notes notes1=new Notes();
        notes1.notesTitle=title;
        notes1.notesSubTitle=subtitle;
        notes1.notes=notes;
        notes1.notesDate=sequence.toString();
        notes1.notesPriority=priority;
        notesViewModal.insertNote(notes1);
        Toast.makeText(this, "Notes Create", Toast.LENGTH_SHORT).show();
        finish();


    }
}