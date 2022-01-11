package ru.gb.notes.data;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRepoImpl implements Repo {

    ArrayList<Note> notesList = new ArrayList<Note>();
    private int counter = 0;

    @Override
    public int create(Note note) {
        int id = counter++;
        note.setId(id);
        notesList.add(note);
        return id;
    }

    @Override
    public Note read(int id) {
        for (int i = 0; i < notesList.size(); i++) {
            if (notesList.get(i).getId() == id) {
                return notesList.get(i);
            }
        }
        return null;
    }

    @Override
    public void update(Note note) {
        for (int i = 0; i < notesList.size(); i++) {
            if (notesList.get(i).getId() == note.getId()) {
                notesList.set(i, note);
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        notesList.remove(id);
    }

    @Override
    public List<Note> getAll() {
        return notesList;
    }

}

