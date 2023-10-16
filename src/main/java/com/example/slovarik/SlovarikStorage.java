package com.example.slovarik;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.TreeMap;

public class SlovarikStorage {

    public static class SlovarikStorageHolder {
        private static final SlovarikStorage INSTANCE = new SlovarikStorage();
    }

    public static SlovarikStorage getInstance() {
        return SlovarikStorageHolder.INSTANCE;
    }

    static final String FILE_NAME = "slovarik.txt";

    public static final Map<String, String> slovarik = new LinkedHashMap<>();

    private SlovarikStorage() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            try (FileWriter writer = new FileWriter(FILE_NAME)) {
                writer.write("");
                writer.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        readFromSlovarik();

    }

    public static String getSlovarik() {
        return slovarik.toString();
    }

    public static void tableUpdate() {

//        ObservableList<TreeMap<String, String>> tableOfTranslations = FXCollections.observableArrayList(slovarik);
//        TableView<TreeMap<String, String>> table = new TableView<>(tableOfTranslations);
//        TableColumn<Map<String, String>, String> wordColumn = new TableColumn<>("Слово");
//        wordColumn.setCellValueFactory(cellData -> cellData.getValue());

    }

    static String writeToSlovarik(String wordPlusTranslate) {
        if (wordPlusTranslate.isEmpty()) {
            return "Перевод не может быть пустым";
        }
        if (!slovarikUpdate(wordPlusTranslate)) {
            return "Перевод " + wordPlusTranslate + " уже добавлен в словарь";
        }
        try (FileWriter writer = new FileWriter(FILE_NAME)) {

            for (Map.Entry<String, String> entry : slovarik.entrySet()) {
                writer.write(entry.getKey() + " - " + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "Перевод " + wordPlusTranslate + " добавлен в словарь";
    }

    private static boolean slovarikUpdate(String text) {
        var map = text.split(" - ");
        if (slovarik.containsKey(map[0])) {
            return false;
        }
        slovarik.put(map[0], map[1]);
        return true;
    }

    public void readFromSlovarik() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" - ");
                slovarik.put(parts[0], parts[1]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
