module com.example.slovarik {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
//    requires eu.hansolo.tilesfx;

    opens com.example.slovarik to javafx.fxml;
    exports com.example.slovarik;
}