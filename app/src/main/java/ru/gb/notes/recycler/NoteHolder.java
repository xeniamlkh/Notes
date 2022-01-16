package ru.gb.notes.recycler;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.gb.notes.R;
import ru.gb.notes.data.Note;

public class NoteHolder extends RecyclerView.ViewHolder {

    private TextView titleInHolder;
    private TextView descriptionInHolder;

    private Note myHolderNote;

    public NoteHolder(@NonNull View itemView, NotesAdapter.OnNoteClickListener listener) {
        super(itemView);

        titleInHolder = itemView.findViewById(R.id.note_title);
        descriptionInHolder = itemView.findViewById(R.id.note_description);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onNoteClick(myHolderNote);
            }
        });

    }

    void bind(Note note) {
        titleInHolder.setText(note.getTitle());
        descriptionInHolder.setText(note.getDescription());

        myHolderNote = note;
    }
}
