package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Ron Clements", 88, 18.99f);

        Book book = new Book("Effective Java", "Programming", 35.5f);
        book.addAuthor("Joshua Bloch");

        CompactDisc cd = new CompactDisc("Classic Hits", "Music", 20.0f, "Beethoven");
        cd.addTrack(new Track("Symphony No.9", 10));
        cd.addTrack(new Track("Fur Elise", 5));

        // Add items to cart
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);
        cart.addMedia(book);
        cart.addMedia(cd);

        // Print cart
        cart.printCart();

        // Search by title and ID
        System.out.println("\nSearch by title 'Star Wars': " + cart.searchByTitle("Star Wars"));
        System.out.println("Search by ID 1: " + cart.searchById(1));

        // Sort cart
        System.out.println("\nSort by title then cost:");
        cart.sortByTitleCost();

        System.out.println("\nSort by cost then title:");
        cart.sortByCostTitle();

        // Remove item
        cart.removeMedia(dvd2);

        // Print cart after removal
        System.out.println("\nCart after removal:");
        cart.printCart();

        // Clear cart
        cart.clearCart();
        System.out.println("\nCart after placing order:");
        cart.printCart();
    }
}
