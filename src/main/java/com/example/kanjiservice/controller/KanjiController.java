package com.example.kanjiservice.controller;

import com.example.kanjiservice.mapper.KanjiMapper;
import com.example.kanjiservice.model.response.KanjiResponse;
import com.example.kanjiservice.service.KanjiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins ="http://localhost:3000", allowCredentials = "true")
public class KanjiController {

    private final KanjiService kanjiService;

    public KanjiController(KanjiService kanjiService) {
        this.kanjiService = kanjiService;
    }

    @GetMapping("/kanji/{id}")
    public ResponseEntity<KanjiResponse> getKanjiById(@PathVariable Long id) {
        return ResponseEntity.ok(KanjiMapper.INSTANCE.toKanjiResponse(kanjiService.getById(id)));
    }

    @GetMapping("/jlpt/{level}/kanji")
    public ResponseEntity<List<KanjiResponse>> getKanjiListByLevel(@PathVariable int level) {
        return ResponseEntity.ok(KanjiMapper.INSTANCE.toKanjiResponseList(kanjiService.getAllByJlptLevel(level)));
    }

    @GetMapping("/jlpt/{level}/kanji/random")
    public ResponseEntity<List<KanjiResponse>> getKanjiListByLevelInRandomOrder(@PathVariable int level) {
        return ResponseEntity.ok(KanjiMapper.INSTANCE.toKanjiResponseList(kanjiService.getAllByJlptLevelInRandomOrder(level)));
    }

    @GetMapping("/jlpt/{level}/kanji/random/{amount}")
    public ResponseEntity<List<KanjiResponse>> getKanjiListByLevelInRandomOrderAndWithSpecifiedAmount(@PathVariable int level, @PathVariable int amount) {
        return ResponseEntity.ok(KanjiMapper.INSTANCE.toKanjiResponseList(kanjiService.getAllByJlptLevelInRandomOrderWithSpecifiedAmount(level, amount)));
    }


}
