package Model;

public class Note extends NoteAbstract{
    private String id = "";
    public String title;
    public String data;

    public Note(String title, String data) {
        super(title, data);
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }



}
