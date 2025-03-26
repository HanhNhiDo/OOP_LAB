package com.aims.model;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemOrder = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;
    private float totalCost = 0; 

    // Thêm DVD vào giỏ hàng
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemOrder[qtyOrdered] = disc;
            totalCost += disc.getCost(); 
            qtyOrdered++;
            System.out.println("The disc has been added.");
            if (qtyOrdered == MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is full.");
            }
        } else {
            System.out.println("The cart is full. Cannot add more discs.");
        }
    }
 // Phương thức thêm một mảng các DVD vào giỏ hàng (method overloading by array)
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc dvd : dvdList) {
            addDigitalVideoDisc(dvd); // Gọi lại phương thức addDigitalVideoDisc cho mỗi DVD trong mảng
        }
    }

    // Phương thức thêm nhiều DVD vào giỏ hàng (method overloading by varargs)
    public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
        for (DigitalVideoDisc dvd : dvds) {
            addDigitalVideoDisc(dvd); // Gọi lại phương thức addDigitalVideoDisc cho mỗi DVD
        }
    }
    // Phương thức thêm hai DVD vào giỏ hàng (method overloading by number of parameters)
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered + 2 <= MAX_NUMBERS_ORDERED) {
            itemOrder[qtyOrdered] = dvd1;
            itemOrder[qtyOrdered + 1] = dvd2;
            totalCost += dvd1.getCost() + dvd2.getCost(); // Cập nhật tổng chi phí
            qtyOrdered += 2;
            System.out.println("The two discs have been added.");
        } else {
            System.out.println("The cart is full. Cannot add more discs.");
        }
    }
    // Xóa DVD khỏi giỏ hàng
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrder[i] == disc) {
                System.out.println("The disc " + disc.getTitle() + " has been removed.");
                totalCost -= disc.getCost(); 
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemOrder[j] = itemOrder[j + 1];
                }
                itemOrder[qtyOrdered - 1] = null;
                qtyOrdered--;
                return;
            }
        }
        System.out.println("The disc " + disc.getTitle() + " is not in the cart.");
    }

    // Phương thức tính tổng chi phí
    public float totalCost() {
        return totalCost; 
    }

    // In ra tất cả các DVD trong giỏ hàng
    public void printCart() {
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemOrder[i].getTitle() + " " + itemOrder[i].getCost());
        }
    }
}
