package com.example.kanjiservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "kanji_symbol")
@Getter
@Setter
public class Kanji {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "reading_on")
    private String readingOn;

    @Column(name = "reading_kun")
    private String readingKun;

    @Column(name = "meaning")
    private String meaning;

    @Column(name = "example_sentence")
    private String exampleSentence;

    @Column(name = "example_sentence_translation")
    private String exampleSentenceTranslation;

    @Column(name = "jlpt_level")
    private int JLPT;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "kanji")
    private List<UserKanji> UserKanjis = new ArrayList<>();

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<UserKanji> getUserKanjis() {
        return UserKanjis;
    }

    public void setUserKanjis(List<UserKanji> userKanjis) {
        UserKanjis = userKanjis;
    }
}
