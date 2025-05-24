package hust.soict.hedspi.aims.store;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import hust.soict.hedspi.aims.media.*;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();
    
    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("Added to store: " + media.getTitle());
        } else {
            System.out.println("Media already in store.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("Removed from store: " + media.getTitle());
        } else {
            System.out.println("Media not found in store.");
        }
    }

    public Media searchByTitle(String title) {
        for (Media m : itemsInStore) {
            if (m.getTitle().equalsIgnoreCase(title)) return m;
        }
        return null;
    }

    public void printStore() {
        int i = 1;
        for (Media m : itemsInStore) {
            System.out.println(i++ + ". " + m);
        }
    }
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
 // ObservableList để JavaFX TableView dùng
    private static final ObservableList<Media> storeItemsFX = FXCollections.observableArrayList();

    /** Khởi tạo dữ liệu mẫu (gọi trong Aims.java) */
    public static void initData() {
        storeItemsFX.clear();
        storeItemsFX.add(new Book("The Great Gatsby","Novel", 10.99f));
        storeItemsFX.add(new Book("1984","Dystopia", 8.50f));
        
    }

    /** Lấy danh sách cho TableView */
    public static ObservableList<Media> getStoreItemsFX() {
        return storeItemsFX;
    }
}