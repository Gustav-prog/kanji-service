package com.example.kanjiservice.repository;

import com.example.kanjiservice.entity.Kanji;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KanjiRepository extends JpaRepository<Kanji, Long> {

    List<Kanji> getAllByJLPT(int jlpt);
}
