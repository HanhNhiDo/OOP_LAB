package com.aims.model;

public class TestPassingParameter {

    public static void main(String[] args) {
        // Tạo đối tượng DVD
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        // In ra tiêu đề của jungleDVD và cinderellaDVD trước khi swap
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        // Gọi phương thức swap
        swap(jungleDVD, cinderellaDVD);

        // In ra tiêu đề của jungleDVD và cinderellaDVD sau khi swap
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        // Thay đổi tiêu đề của jungleDVD
        changeTitle(jungleDVD, cinderellaDVD.getTitle());

        // In ra tiêu đề của jungleDVD sau khi thay đổi
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    // Phương thức swap không thay đổi đối tượng gốc (pass by value)
    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    // Phương thức thay đổi tiêu đề của DVD (pass by reference)
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title); // Thay đổi tiêu đề của đối tượng gốc
        dvd = new DigitalVideoDisc(oldTitle); // Tạo một đối tượng mới, nhưng không ảnh hưởng đến đối tượng gốc
    }
}
