package Model;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Repository implements Storable {
    private NoteMapper mapper = new NoteMapper();

    private FileManager fileManager;

    public Repository(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    @Override
    public void createNote(Note note) {
        List<Note> notes = getAllNotes();
        int max = 0;
        for (Note item : notes) {
            int id = Integer.parseInt(item.getId()); //!!!!!!!!!!!
            if (max < id) {
                max = id;
            }
        }
        int newId = max + 1;
        String id = String.format("%d", newId);
        note.setId(id);
        notes.add(note);
        writeToFile(notes);
//        return id;
    }

    @Override
    public List<Note> getAllNotes() {
        List<String> lines = fileManager.readAllLines();
        List<Note> notes = new ArrayList<>();
        for (String line : lines) {
            notes.add(mapper.map(line));
        }
        return notes;
    }


    @Override
    public void updateNote(String id, Note note) {
        List<Note> notes = getAllNotes();
        Note toEdit = notes.stream().filter(i -> i.getId().equals(id)).findFirst().get();
        toEdit.setTitle(note.getTitle());
        toEdit.setData(note.getData());
        writeToFile(notes);

    }

    @Override
    public void deleteNote(String id) {
        List<Note> notes = getAllNotes();
        Note toDelete = notes.stream().filter(i -> i.getId().equals(id)).findFirst().get();
        notes.remove(toDelete);
        writeToFile(notes);
    }

    @Override
    public Note readNote(String id) {
        List<Note> notes = getAllNotes();
        for (Note note : notes) {
            if (note.getId().equals(id)) {
                return note;
            }
        }
//        Note toRead = notes.stream().filter(i -> i.getId().equals(id)).findFirst().get();
        return null;
    }


    private void writeToFile(@NotNull List<Note> notes) {
        List<String> lines = new ArrayList<>();
        for (Note note : notes) {
            lines.add(mapper.map(note));
        }
        fileManager.saveAllLines(lines);
    }

}
