module hust.soict.hedspi.aims {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens hust.soict.hedspi.aims.screen.customer.controller to javafx.fxml;
    // Nếu còn package controller khác thì thêm opens tương tự
}
