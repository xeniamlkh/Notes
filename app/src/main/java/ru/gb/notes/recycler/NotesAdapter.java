package ru.gb.notes.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.gb.notes.R;
import ru.gb.notes.data.Note;

public class NotesAdapter extends RecyclerView.Adapter<NoteHolder> {

    private List<Note> adapterNotes = new ArrayList<>();

    public void setNotes(List<Note> notes) {
        adapterNotes = notes;
    }

    public interface OnNoteClickListener {
        void onNoteClick(Note note);
    }

    private OnNoteClickListener myNoteListener;

    public void setOnNoteClickListener(OnNoteClickListener listener) {
        myNoteListener = listener;
    }


    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new NoteHolder(view, myNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        holder.bind(adapterNotes.get(position));
    }

    @Override
    public int getItemCount() {
        return adapterNotes.size();
    }
}
