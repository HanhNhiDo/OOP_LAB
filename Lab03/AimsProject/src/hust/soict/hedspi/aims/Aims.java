package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;
import java.util.Scanner;

public class Aims {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Store store = new Store();
    private static final Cart cart = new Cart();

    public static void main(String[] args) {
        
        store.addMedia(new DigitalVideoDisc("Avengers", "Action", "Marvel", 120, 24.99f));
        Book book = new Book("Effective Java", "Programming", 35.5f);
        book.addAuthor("Joshua Bloch");
        store.addMedia(book);
        CompactDisc cd = new CompactDisc("Classical Collection", "Music", 18.0f, "Mozart");
        cd.addTrack(new Track("Symphony No. 40", 8));
        store.addMedia(cd);

        mainMenu();
    }

    public static void showMenu() {
        System.out.println("AIMS:");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void mainMenu() {
        boolean running = true;
        while (running) {
            showMenu();
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 -> storeMenu();
                case 2 -> updateStoreMenu();
                case 3 -> cartMenu();
                case 0 -> running = false;
                default -> System.out.println("Invalid option");
            }
        }
    }

    public static void storeMenu() {
        boolean inStore = true;
        while (inStore) {
            System.out.println("\nItems in store:");
            store.printStore();
            System.out.println("Options:");
            System.out.println("--------------------------------");
            System.out.println("1. See a media’s details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter media title: ");
                    String title = scanner.nextLine();
                    Media m = store.searchByTitle(title);
                    if (m != null) {
                        System.out.println(m);
                        if (m instanceof Playable) mediaDetailsMenu((Playable) m);
                    } else {
                        System.out.println("Media not found.");
                    }
                }
                case 2 -> {
                    System.out.print("Enter media title to add: ");
                    String title = scanner.nextLine();
                    Media m = store.searchByTitle(title);
                    if (m != null) {
                        cart.addMedia(m);
                        System.out.println("Added to cart.");
                    } else System.out.println("Media not found.");
                }
                case 3 -> {
                    System.out.print("Enter media title to play: ");
                    String title = scanner.nextLine();
                    Media m = store.searchByTitle(title);
                    if (m instanceof Playable) ((Playable) m).play();
                    else System.out.println("Cannot play this media.");
                }
                case 4 -> cartMenu();
                case 0 -> inStore = false;
                default -> System.out.println("Invalid option");
            }
        }
    }

    public static void mediaDetailsMenu(Playable media) {
        boolean inMediaDetails = true;
        while (inMediaDetails) {
            System.out.println("\nMedia Options:");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> cart.addMedia((Media) media);
                case 2 -> media.play();
                case 0 -> inMediaDetails = false;
                default -> System.out.println("Invalid option");
            }
        }
    }

    public static void cartMenu() {
        boolean cartOpen = true;
        while (cartOpen) {
            System.out.println("********** CART MENU **********");
            System.out.println("1. Filter media in cart");
            System.out.println("2. Sort media in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.print("Choose option: ");
            int input = scanner.nextInt();
            scanner.nextLine();
            switch (input) {
                case 1 -> {
                    System.out.print("Search by (1) ID or (2) Title? ");
                    int mode = scanner.nextInt(); scanner.nextLine();
                    if (mode == 1) {
                        System.out.print("Enter ID: ");
                        int id = scanner.nextInt();
                        Media m = cart.searchById(id);
                        System.out.println(m != null ? m : "Not found");
                    } else {
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();
                        Media m = cart.searchByTitle(title);
                        System.out.println(m != null ? m : "Not found");
                    }
                }
                case 2 -> {
                    System.out.print("Sort by (1) Title or (2) Cost? ");
                    int sortOption = scanner.nextInt();
                    if (sortOption == 1) cart.sortByTitleCost();
                    else cart.sortByCostTitle();
                }
                case 3 -> {
                    System.out.print("Enter title of media to remove: ");
                    String title = scanner.nextLine();
                    Media m = cart.searchByTitle(title);
                    if (m != null) cart.removeMedia(m);
                    else System.out.println("Item not found in cart.");
                }
                case 4 -> {
                    System.out.print("Enter title to play: ");
                    String title = scanner.nextLine();
                    Media m = cart.searchByTitle(title);
                    if (m instanceof Playable) ((Playable) m).play();
                    else System.out.println("Media cannot be played.");
                }
                case 5 -> {
                    cart.printCart();
                    System.out.println("Placing order...");
                    cart.clearCart();
                }
                case 0 -> cartOpen = false;
                default -> System.out.println("Invalid option");
            }
        }
    }

    public static void updateStoreMenu() {
        System.out.println("1. Add Media to Store");
        System.out.println("2. Remove Media from Store");
        System.out.print("Choose option: ");
        int opt = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        if (opt == 1) {
            System.out.print("Enter category and cost: ");
            String category = scanner.nextLine();
            float cost = scanner.nextFloat();
            store.addMedia(new DigitalVideoDisc(title, category, "", 90, cost));
        } else {
            Media m = store.searchByTitle(title);
            if (m != null) store.removeMedia(m);
            else System.out.println("Not found");
        }
    }
}
