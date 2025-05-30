package hust.soict.hedspi.aims;
import hust.soict.hedspi.aims.screen.customer.controller.*;
import hust.soict.hedspi.aims.cart.*;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Scanner;

public class Aims extends Application {
    private static Store store;
    private static Cart cart;

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader();
        System.out.println(Aims.class.getResource(STORE_FXML_FILE_PATH));

        fxmlLoader.setLocation(Aims.class.getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store, cart);
        fxmlLoader.setController(viewStoreController);
        Parent parent = fxmlLoader.load();

        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Store");
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
        cart = new Cart();
        store.initData();
        launch(args);
    }

}
