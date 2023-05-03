package ru.liga.translator.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.liga.translator.service.translate.impl.rule.RuleFour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DictionaryFromFileService {


    public Map<String, String> getDictionaryFromFile(String searchRuleElement, String swapRuleElement, String fileName) {
        List<String> words = getWordsFromFile(fileName);
        return words.stream().collect(Collectors.toMap(word -> word.toLowerCase().replaceAll(searchRuleElement, swapRuleElement), word -> word.toLowerCase()));
    }

    private List<String> getWordsFromFile(String fileName) {
        List<String> listFromFile = new ArrayList<>();

        InputStream inputStream = RuleFour.class.getClassLoader().getResourceAsStream(fileName);
        if (inputStream == null) {
            log.error("Файл не найден " + fileName);
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            String str;
            while ((str = br.readLine()) != null) {
                if (!str.isEmpty()) {
                    str = str.replaceAll("\\s+", "")
                            .replaceAll("\\(", ",")
                            .replaceAll("\\)", "");
                    listFromFile.addAll(Arrays.asList(str.split(",")));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listFromFile;
    }
}
