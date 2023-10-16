package com.example.slovarik;

public class TranslationModel {

    private String word;
    private String translation;

    public TranslationModel(String word, String translation) {
        this.word = word;
        this.translation = translation;
    }

    public String getWord() {
        return word;
    }

    public String getTranslation() {
        return translation;
    }
}
