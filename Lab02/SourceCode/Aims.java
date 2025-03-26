package com.aims.model;
public class Aims {
    public static void main(String[] args) {
        // Create a new cart
        Cart anOrder = new Cart();

        // Create new DVD objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Ron Clements", 88, 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);
        // Thêm hai DVD vào giỏ hàng 
        anOrder.addDigitalVideoDisc(dvd1, dvd2);
        // Thêm các DVD vào giỏ hàng bằng varargs
        anOrder.addDigitalVideoDisc(dvd1, dvd2, dvd3);
        // Print all DVD items in the cart
        System.out.println("List of DVDs in the cart:");
        anOrder.printCart();

        // Remove a DVD from the cart
        anOrder.removeDigitalVideoDisc(dvd2);

        // Print the updated cart after removing the DVD
        System.out.println("\nUpdated cart after removing a DVD:");
        anOrder.printCart();

        // Print the total cost after removal
        System.out.println("Total Cost is: " + anOrder.totalCost());
    }
}
