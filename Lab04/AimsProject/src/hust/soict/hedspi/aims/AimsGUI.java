package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.screen.manager.StoreManagerScreen;

public class AimsGUI {
    public static void main(String[] args) {
        Store store = new Store();
        store.addMedia(new DigitalVideoDisc("Avengers", "Action", "Marvel", 120, 24.99f));
        Book book = new Book("Effective Java", "Programming", 35.5f);
        book.addAuthor("Joshua Bloch");
        store.addMedia(book);
        CompactDisc cd = new CompactDisc("Classical Collection", "Music", 18.0f, "Mozart");
        cd.addTrack(new Track("Symphony No. 40", 8));
        store.addMedia(cd);
        new StoreManagerScreen(store);
    }
}
