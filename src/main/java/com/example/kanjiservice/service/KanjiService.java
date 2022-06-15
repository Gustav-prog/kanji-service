package com.example.kanjiservice.service;

import com.example.kanjiservice.entity.Kanji;
import com.example.kanjiservice.repository.KanjiRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class KanjiService {

    private final KanjiRepository kanjiRepository;

    public KanjiService(KanjiRepository kanjiRepository) {
        this.kanjiRepository = kanjiRepository;
    }

    public Kanji getById(Long id) {
        Optional<Kanji> kanji = kanjiRepository.findById(id);
        return kanji.get();
    }

    public List<Kanji> getAllByJlptLevel(int level) {
       return kanjiRepository.getAllByJLPT(level);
    }

    public List<Kanji> getAllByJlptLevelInRandomOrder(int level) {
        List<Kanji> kanjis = kanjiRepository.getAllByJLPT(level);
        Collections.shuffle(kanjis);
        return kanjis;
    }

    public List<Kanji> getAllByJlptLevelInRandomOrderWithSpecifiedAmount(int level, int amount) {
       List<Kanji> kanjis = getAllByJlptLevelInRandomOrder(level);
       return kanjis.subList(0, amount);
    }
}
