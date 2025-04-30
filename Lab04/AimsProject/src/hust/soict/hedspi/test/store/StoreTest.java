package hust.soict.hedspi.test.store;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd = new DigitalVideoDisc("Inception", "Sci-Fi", "Nolan", 148, 30.0f);
        Book book = new Book("Clean Code", "Programming", 40.0f);
        book.addAuthor("Robert C. Martin");
        CompactDisc cd = new CompactDisc("Top Hits", "Music", 25.0f, "Various Artists");
        cd.addTrack(new Track("Hit Song", 4));

        // Add to store
        store.addMedia(dvd);
        store.addMedia(book);
        store.addMedia(cd);

        // Print store
        System.out.println("\nStore Inventory:");
        store.printStore();

        // Search by title
        System.out.println("\nSearch by title 'Inception':");
        System.out.println(store.searchByTitle("Inception"));

        // Remove media
        store.removeMedia(book);
        System.out.println("\nStore Inventory after removing book:");
        store.printStore();
    }
}