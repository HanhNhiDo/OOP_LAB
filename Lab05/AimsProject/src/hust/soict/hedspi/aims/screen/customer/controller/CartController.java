package hust.soict.hedspi.aims.screen.customer.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

public class CartController {
    private final Cart cart;
    private final Store store;

    public CartController(Cart cart, Store store) {
        this.cart = cart;
        this.store = store;
    }

    @FXML private TableColumn<Media, Integer> colMediaId;
    @FXML private TableColumn<Media, String> colMediaTitle;
    @FXML private TableColumn<Media, String> colMediaCategory;
    @FXML private TableColumn<Media, Float> colMediaCost;
    @FXML private TableView<Media> tblMedia;
    @FXML private Label costLabel;
    @FXML private ToggleGroup filterCategory;
    @FXML private RadioButton radioBtnFilterId;
    @FXML private RadioButton radioBtnFilterTitle;
    @FXML private TextField tfFilter;
    @FXML private Button btnPlay;
    @FXML private Button btnRemove;

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Place order");
        confirm.setHeaderText("Are you sure you want to place the order?");
        confirm.setContentText("Total cost: " + roundTotalCost(cart.totalCost()) + " $");

        Optional<ButtonType> result = confirm.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            cart.clear();
            showFilteredMedia(tfFilter.getText());
            updateTotalCost();
            Alert info = new Alert(Alert.AlertType.INFORMATION);
            info.setTitle("Order placed");
            info.setHeaderText(null);
            info.setContentText("Your order has been placed successfully.");
            info.showAndWait();
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (Exception e) {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Play Error");
                error.setHeaderText(null);
                error.setContentText(e.getMessage());
                error.showAndWait();
            }
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
            showFilteredMedia(tfFilter.getText());
            updateTotalCost();
        }
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/hedspi/aims/screen/customer/view/Store.fxml"));
            loader.setController(new ViewStoreController(store, cart));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        showFilteredMedia("");
        updateTotalCost();

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> obs, Media oldVal, Media newVal) {
                updateButtonBar(newVal);
            }
        });

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> obs, String oldVal, String newVal) {
                showFilteredMedia(newVal);
            }
        });
    }

    private void updateButtonBar(Media media) {
        boolean has = media != null;
        btnRemove.setVisible(has);
        btnPlay.setVisible(has && media instanceof Playable);
    }

    private void showFilteredMedia(String filter) {
        ObservableList<Media> filteredList = FXCollections.observableArrayList();
        if (filter == null || filter.trim().isEmpty()) {
            List<Media> all = cart.getItemsOrdered();
            if (all != null) filteredList.addAll(all);
        } else if (radioBtnFilterId.isSelected()) {
            try {
                int id = Integer.parseInt(filter.trim());
                Media m = cart.searchByID(id);
                if (m != null) filteredList.add(m);
            } catch (NumberFormatException e) {
                // invalid number, do nothing
            }
        } else if (radioBtnFilterTitle.isSelected()) {
            Media m2 = cart.searchByTitle(filter);
            if (m2 != null) filteredList.add(m2);
        }
        tblMedia.setItems(filteredList);
    }

    private void updateTotalCost() {
        costLabel.setText(roundTotalCost(cart.totalCost()) + " $");
    }

    private String roundTotalCost(float cost) {
        return new DecimalFormat("#.##").format(cost);
    }
}
