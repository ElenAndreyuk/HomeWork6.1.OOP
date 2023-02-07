package Model;

import java.time.LocalDateTime;
import java.util.List;

public class LoggerDecorator implements Storable{
    Storable storable;

    public LoggerDecorator(Storable storable) {
        this.storable = storable;
    }




    @Override
    public List<Note> getAllNotes() {
        System.out.println("все заметки " + LocalDateTime.now());
        return storable.getAllNotes();
    }

    @Override
    public void createNote(Note note) {
        System.out.println("создаем заметку " + LocalDateTime.now());
        storable.createNote(note);
    }


    @Override
    public void updateNote(String id, Note note) {
        System.out.println("обновляем заметку " + LocalDateTime.now());
        storable.updateNote(id, note);
    }

    @Override
    public void deleteNote(String id) {
        System.out.println("все заметки " + LocalDateTime.now());
        storable.deleteNote(id);
    }

    @Override
    public Note readNote(String id) {
        System.out.println("выводим заметку " + LocalDateTime.now());
        return storable.readNote(id);
    }

   
}
