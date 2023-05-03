package ru.liga.translator.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.liga.translator.service.DictionaryFromFileService;

import java.util.Map;

@Component
@Getter
@RequiredArgsConstructor
public class DictionaryRuleFour {
    private final DictionaryFromFileService dictionaryFromFileService = new DictionaryFromFileService();
    private final Map<String, String> dictionary = dictionaryFromFileService.getDictionaryFromFile("ѣ", "е", "rule_four.txt");

}
