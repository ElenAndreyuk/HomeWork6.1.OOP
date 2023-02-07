package Model;

public class Note{
//        extends NoteAbstract{
//    private String id = "";
    private String id;
    public String title;
    public String data;

    public Note(String title, String data) {
        this.title = title;
        this.data = data;
    }
    public Note(String id, String title, String data) {
        this(title, data);
        this.id = id;
    }
    @Override
    public String toString() {
        return "id: " + id + "\n" +
                "Заголовок: " + title + "\n" +
                "Содержание: " + data + "\n";
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
