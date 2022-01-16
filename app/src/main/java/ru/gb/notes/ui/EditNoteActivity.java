package ru.gb.notes.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ru.gb.notes.R;

public class EditNoteActivity extends AppCompatActivity {

    private EditText title;
    private EditText description;
    private Button saveNoteButton;
    private int id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        title = (EditText) findViewById(R.id.edit_note_title);
        description = (EditText) findViewById(R.id.edit_note_description);
        saveNoteButton = (Button) findViewById(R.id.btn_save_note);

        Intent intent = getIntent();

        id = intent.getIntExtra("NOTE_ID", 0);

        title.setText(intent.getStringExtra("NOTE_TITLE"));
        description.setText(intent.getStringExtra("NOTE_DESCRIPTION"));

        saveNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent();
                intent1.putExtra("NOTE_TITLE", title.getText().toString());
                intent1.putExtra("NOTE_DESCRIPTION", description.getText().toString());
                intent1.putExtra("NOTE_ID", id);
                setResult(RESULT_OK, intent1);
                finish();
            }
        });
    }

}
