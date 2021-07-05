package com.example.Notes.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Toast;

import com.example.Notes.Modal.Notes;
import com.example.Notes.R;
import com.example.Notes.ViewModal.NotesViewModal;
import com.example.Notes.databinding.ActivityInsertNotesBinding;
import com.example.Notes.databinding.ActivityUpdateNotesBinding;

import java.util.Date;

public class UpdateNOtesActivity extends AppCompatActivity {
    ActivityUpdateNotesBinding binding;
    String priority ="1";
    String stitle,ssubtitle,snotes,spriority;
    int iid;
    NotesViewModal notesViewModal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_notes);
        binding= ActivityUpdateNotesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        iid=getIntent().getIntExtra("id",0);
        stitle=getIntent().getStringExtra("title");
        ssubtitle=getIntent().getStringExtra("subtitle");
        spriority=getIntent().getStringExtra("priority");
        snotes=getIntent().getStringExtra("note");
        binding.uptitle.setText(stitle);
        binding.upSubtitle.setText(ssubtitle);
        binding.upNotes.setText(snotes);

        if(spriority.equals("1")){
            binding.greenPriority.setImageResource(R.drawable.ic_baseline_done_24);
        }else if(spriority.equals("2"))
        {
            binding.yellowPriority.setImageResource(R.drawable.ic_baseline_done_24);
        }else if(spriority.equals("3"))
        {
            binding.RedPriority.setImageResource(R.drawable.ic_baseline_done_24);
        }



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
        binding.UpdateNodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String title=binding.uptitle.getText().toString();
                String subtitle=binding.upSubtitle.getText().toString();
                String notes=binding.upNotes.getText().toString();
                UpdateNotes(title,subtitle,notes);

            }

            private void UpdateNotes(String title, String subtitle, String notes) {
                Date date=new Date();
                CharSequence sequence= DateFormat.format("MMMM d,yyyy",date.getTime());
                Notes  updateNotes=new Notes();
                updateNotes.id=iid;
                updateNotes.notesTitle=title;
                updateNotes.notesSubTitle=subtitle;
                updateNotes.notes=notes;
                updateNotes.notesDate=sequence.toString();
                updateNotes.notesPriority=priority;
                notesViewModal.insertNote(updateNotes);

                Toast.makeText(UpdateNOtesActivity.this, "Notes Updated Succsfully", Toast.LENGTH_SHORT).show();
            }
        });

    }
}