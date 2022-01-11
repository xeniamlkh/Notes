package ru.gb.notes.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import ru.gb.notes.R;
import ru.gb.notes.data.InMemoryRepoImpl;
import ru.gb.notes.data.Note;
import ru.gb.notes.recycler.NotesAdapter;

public class NotesListActivity extends AppCompatActivity implements NotesAdapter.OnNoteClickListener {

    private InMemoryRepoImpl repositoryNotes = new InMemoryRepoImpl();

    RecyclerView myView;

    private NotesAdapter adapter = new NotesAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_list);

        fillRepositoryNotes();

        myView = findViewById(R.id.recycler_view);
        myView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setNotes(repositoryNotes.getAll());
        myView.setAdapter(adapter);
        adapter.setOnNoteClickListener(this);

    }

    private void fillRepositoryNotes() {
        repositoryNotes.create(new Note("Note 1", "description 1"));
        repositoryNotes.create(new Note("Note 2", "description 2"));
        repositoryNotes.create(new Note("Note 3", "description 3"));
        repositoryNotes.create(new Note("Note 4", "description 4"));
        repositoryNotes.create(new Note("Note 5", "description 5"));
        repositoryNotes.create(new Note("Note 6", "description 6"));
        repositoryNotes.create(new Note("Note 7", "description 7"));
        repositoryNotes.create(new Note("Note 8", "description 8"));
        repositoryNotes.create(new Note("Note 9", "description 9"));
        repositoryNotes.create(new Note("Note 10", "description 10"));
        repositoryNotes.create(new Note("Note 11", "description 11"));
        repositoryNotes.create(new Note("Note 12", "description 12"));
        repositoryNotes.create(new Note("Note 13", "description 13"));
        repositoryNotes.create(new Note("Note 14", "description 14"));
        repositoryNotes.create(new Note("Note 15", "description 15"));
    }

    @Override
    public void onNoteClick(Note note) {
        System.out.println(" NotesListActivity, note.id= " + note.getId());
        Intent intent = new Intent(this, EditNoteActivity.class);
        intent.putExtra("NOTE_TITLE", note.getTitle());
        intent.putExtra("NOTE_DESCRIPTION", note.getDescription());
        intent.putExtra("NOTE_ID", note.getId());
        startActivityForResult(intent, 2222);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.add_btn:
                Intent intent = new Intent(this, NewNoteActivity.class);
                startActivityForResult(intent, 1111);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String titleReceived = data.getStringExtra("NOTE_TITLE");
        String descriptionReceived = data.getStringExtra("NOTE_DESCRIPTION");

        if (requestCode == 1111) {
            System.out.println("11111");
            //repositoryNotes.create(new Note(titleReceived, descriptionReceived));
            adapter.notifyItemInserted(repositoryNotes.create(new Note(titleReceived, descriptionReceived)));
        } else if (requestCode == 2222) {
            int idReceived = data.getIntExtra("NOTE_ID", 0);
            Note note = new Note(idReceived, titleReceived, descriptionReceived);
            repositoryNotes.update(note);
            adapter.notifyItemChanged(idReceived);
        }
    }
}