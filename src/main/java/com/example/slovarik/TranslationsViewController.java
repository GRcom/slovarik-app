package com.example.slovarik;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class TranslationsViewController implements Initializable {
    @FXML
    public Label translationText;


    @FXML
    public void nextTranslation() {

        textChange();

    }

    @FXML
    public void prevTranslation() {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void textChange() {

    }

}
