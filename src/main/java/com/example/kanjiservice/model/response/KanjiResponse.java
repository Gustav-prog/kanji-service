package com.example.kanjiservice.model.response;

public class KanjiResponse {

    private Long id;
    private String symbol;
    private String readingOn;
    private String readingKun;
    private String meaning;
    private String exampleSentence;
    private String exampleSentenceTranslation;
    private int JLPT;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getReadingOn() {
        return readingOn;
    }

    public void setReadingOn(String readingOn) {
        this.readingOn = readingOn;
    }

    public String getReadingKun() {
        return readingKun;
    }

    public void setReadingKun(String readingKun) {
        this.readingKun = readingKun;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getExampleSentence() {
        return exampleSentence;
    }

    public void setExampleSentence(String exampleSentence) {
        this.exampleSentence = exampleSentence;
    }

    public String getExampleSentenceTranslation() {
        return exampleSentenceTranslation;
    }

    public void setExampleSentenceTranslation(String exampleSentenceTranslation) {
        this.exampleSentenceTranslation = exampleSentenceTranslation;
    }

    public int getJLPT() {
        return JLPT;
    }

    public void setJLPT(int JLPT) {
        this.JLPT = JLPT;
    }
}

