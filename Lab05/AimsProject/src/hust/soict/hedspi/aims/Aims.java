package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Aims extends Application {
    private static final Store store = new Store();
    private static final Cart  cart  = new Cart();

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Gọi static initData()
        Store.initData();

        String fxmlPath = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));

        loader.setController(new ViewStoreController(store, cart));

        Parent root = loader.load();
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Store");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
