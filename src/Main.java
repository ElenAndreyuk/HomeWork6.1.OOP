import Controller.NoteController;
import Model.FileManager;
import Model.LoggerDecorator;
import Model.Repository;
import Model.Storable;
import View.ViewNote;

public class Main {
    public static void main(String[] args) throws Exception {

        FileManager fileManager = new FileManager("notes.txt");
        Storable repository= new LoggerDecorator(new Repository(fileManager));
        NoteController controller = new NoteController(repository);
        ViewNote viewNote = new ViewNote(controller);
        viewNote.run();
    }
}