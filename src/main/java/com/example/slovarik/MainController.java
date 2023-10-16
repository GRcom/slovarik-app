package com.example.slovarik;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    public Button startButton;
    @FXML
    public TableColumn<TranslationModel, String> translation;
    @FXML
    public TableColumn<TranslationModel, String> word;

    @FXML
    private Label welcomeText;
    @FXML
    private TextField newWordTextField;
    @FXML
    private Slider textSizeSlider;
    @FXML
    private Button tableButton;
    @FXML
    private TableView<TranslationModel> tableOfTranslations;

    @FXML
    protected void onStartButtonClick() {
        try {
            Parent root = FXMLLoader.load(TranslationsViewController.class.getResource("translations-view.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Переводы");
            stage.setScene(new Scene(root, 640, 240));
            stage.show();
            // Hide this current window (if this is what you want)
//                    ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onAddNewTranslationButtonClick() {
        if (newWordTextField.getText() == null || newWordTextField.getText().isEmpty()) {
            return;
        }
        var text = newWordTextField.getText();
        welcomeText.setText(SlovarikStorage.writeToSlovarik(text));
    }

    @FXML
    protected void onSettingsButtonClick() {
        try {
            Parent root = FXMLLoader.load(SettingsController.class.getResource("settings-view.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Настройки");
            stage.setScene(new Scene(root, 360, 240));
            stage.show();
            // Hide this current window (if this is what you want)
//                    ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void onTableButtonClick() {
        this.initialize(null, null);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        TranslationModel[] table = SlovarikStorage.slovarik.entrySet().stream()
                .map(entry -> new TranslationModel(entry.getKey(), entry.getValue()))
                .toArray(TranslationModel[]::new);
        ObservableList<TranslationModel> tableData = FXCollections.observableArrayList(
                table
        );

        word.setCellValueFactory(new PropertyValueFactory<>("word"));
        translation.setCellValueFactory(new PropertyValueFactory<>("translation"));

        tableOfTranslations.setItems(tableData);



    }
}