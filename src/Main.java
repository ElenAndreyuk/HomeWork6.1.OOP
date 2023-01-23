import Controller.NoteController;
import Model.FileManager;
import Model.Repository;
import View.ViewUser;

public class Main {
    public static void main(String[] args) throws Exception {
        FileManager fileManager = new FileManager("notes.txt");
        Repository repository = new Repository(fileManager);
        NoteController controller = new NoteController(repository);
        ViewUser view = new ViewUser(controller);
        view.run();
    }
}