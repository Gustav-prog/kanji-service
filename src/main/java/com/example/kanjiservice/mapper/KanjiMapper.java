package com.example.kanjiservice.mapper;

import com.example.kanjiservice.entity.Kanji;
import com.example.kanjiservice.model.response.KanjiResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface KanjiMapper {

    KanjiMapper INSTANCE = Mappers.getMapper(KanjiMapper.class);

    KanjiResponse toKanjiResponse(Kanji kanji);

    List<KanjiResponse> toKanjiResponseList(List<Kanji> kanjis);
}
