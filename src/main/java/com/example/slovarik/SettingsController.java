package com.example.slovarik;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;

public class SettingsController {

    @FXML
    public Slider textSizeSlider;

    @FXML
    public Button settingsApproveButton;

    protected void setTextSizeSlider(double value) {
        textSizeSlider.setValue(value);
    }
}
