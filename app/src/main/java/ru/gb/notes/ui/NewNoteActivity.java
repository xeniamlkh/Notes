package ru.gb.notes.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ru.gb.notes.R;

public class NewNoteActivity extends AppCompatActivity {

    private EditText title;
    private EditText description;
    private Button saveNoteButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        title = (EditText) findViewById(R.id.edit_note_title);
        description = (EditText) findViewById(R.id.edit_note_description);
        saveNoteButton = findViewById(R.id.btn_save_note);

        saveNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("NOTE_TITLE", title.getText().toString());
                intent.putExtra("NOTE_DESCRIPTION", description.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}