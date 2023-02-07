package Controller;

import Model.Note;
import Model.Storable;

import java.util.List;

public class NoteController {
    private final Storable repository;

    public NoteController(Storable repository) {
        this.repository = repository;
    }

    public void saveNote(Note note) {
        repository.createNote(note);
    }

    public Note readNote(String id) {
        return repository.readNote(id);
    }

    public List<Note> readList() {
        return repository.getAllNotes();
    }

    public void updateNote(String id, Note note) {
        note.setId(id);
        repository.updateNote(id, note);//!! repository.updateNote(updatedNote);
    }

    public void deleteNote(String id)  {
        List<Note> notes = repository.getAllNotes();
        repository.deleteNote(id);
    }
}