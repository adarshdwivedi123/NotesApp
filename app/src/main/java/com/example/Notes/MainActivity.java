package com.example.Notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.Notes.Activity.InsertNotesActivity;
import com.example.Notes.Adapter.NotesAdapter;
import com.example.Notes.Modal.Notes;
import com.example.Notes.ViewModal.NotesViewModal;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
        FloatingActionButton newNotesBtn;
        NotesViewModal notesViewModal;
        RecyclerView notesRecylerview;
        NotesAdapter adapter;
        TextView nofilter,hightolow,lowtohigh;
        List<Notes> filterNotesallList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newNotesBtn = findViewById(R.id.newNodeBtn);
        notesViewModal = ViewModelProviders.of(this).get(NotesViewModal.class);
        notesRecylerview = findViewById(R.id.notesReclerView);
        nofilter = findViewById(R.id.nofilter);
        hightolow = findViewById(R.id.filterHighTolow);
        lowtohigh = findViewById(R.id.filterlowToHigh);
        nofilter.setBackgroundResource(R.drawable.filter_select_shape);
        nofilter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                loadData(0);
                hightolow.setBackgroundResource(R.drawable.filter_un_shape);
                lowtohigh.setBackgroundResource(R.drawable.filter_un_shape);
                nofilter.setBackgroundResource(R.drawable.filter_select_shape);
            }


        });
        hightolow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData(1);
                hightolow.setBackgroundResource(R.drawable.filter_select_shape);
                lowtohigh.setBackgroundResource(R.drawable.filter_un_shape);
                nofilter.setBackgroundResource(R.drawable.filter_un_shape);

            }
        });
        lowtohigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData(2);
                hightolow.setBackgroundResource(R.drawable.filter_un_shape);
                lowtohigh.setBackgroundResource(R.drawable.filter_select_shape);
                nofilter.setBackgroundResource(R.drawable.filter_un_shape);

            }
        });


        newNotesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InsertNotesActivity.class));
            }
        });
        notesViewModal.getAllNotes.observe(this, new Observer<List<Notes>>() {
            @Override
            public void onChanged(List<Notes> notes) {
                setAdapter(notes);
            }
        });

    }

    private void loadData(int i) {
        if(i ==0)
        {
            notesViewModal.getAllNotes.observe(this, new Observer<List<Notes>>() {
                @Override
                public void onChanged(List<Notes> notes) {
                    setAdapter(notes);
                    filterNotesallList =notes;
                }

            });
        }else if(i ==1)
        {
            notesViewModal.hightolow.observe(this, new Observer<List<Notes>>() {
                @Override
                public void onChanged(List<Notes> notes) {
                    setAdapter(notes);
                    filterNotesallList =notes;

                }
            });
        }else if( i==2)
        {
            notesViewModal.lowtohigh.observe(this, new Observer<List<Notes>>() {
                @Override
                public void onChanged(List<Notes> notes) {
                    setAdapter(notes);
                    filterNotesallList =notes;
                }
            });
        }

    }
    public void setAdapter(List<Notes> notes)
    {


            notesRecylerview.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
            adapter=new NotesAdapter(MainActivity.this,notes);
            notesRecylerview.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_notes,menu);
        MenuItem menuItem=menu.findItem(R.id.app_bar_search);
        SearchView  searchView= (SearchView) menuItem.getActionView();
        searchView.setQueryHint("search not here..");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Notesfilter(newText);
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }

    private void Notesfilter(String newText) {
        ArrayList<Notes>FilterNames=new ArrayList<>();
        for(Notes  notes:this.filterNotesallList)
        {
            if(notes.notesTitle.contains(newText) ||  notes.notesSubTitle.contains(newText))
            {
                FilterNames.add(notes);
            }
        }

        this.adapter.searchNotes(FilterNames);


    }
}