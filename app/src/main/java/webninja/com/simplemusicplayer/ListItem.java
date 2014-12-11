package webninja.com.simplemusicplayer;

public class ListItem {
    public String title;
    public String artist;
    public String file;
    public String attr;

    // default constructor
    public ListItem() {
        this("Title", "Artist","File","Attribution");
    }

    // main constructor
    public ListItem(String title, String artist, String file, String attr) {
        super();
        this.title = title;
        this.artist = artist;
        this.file = file;
        this.attr = attr;
    }

    // String representation
    public String toString() {
        return this.title + " by " + this.artist;
    }
}
