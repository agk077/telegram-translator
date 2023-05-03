package ru.liga.translator.service.translate.impl.rule;

import org.springframework.stereotype.Service;
import ru.liga.translator.service.translate.Translate;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RuleOne implements Translate {
    public static final String CONSONANTS = "бвгджзклмнпрстфхцчшщБВГДЖЗКЛМНПРСТФЧЦЧШЩ";
    public static final String END_RULE_ONE = "ъ";

    private final Set<Character> consonants = CONSONANTS.chars()
            .mapToObj(chr -> (char) chr)
            .collect(Collectors.toSet());

    @Override
    public String translate(String str) {
        if (consonants.contains(str.toCharArray()[str.length() - 1])) {
            return str + END_RULE_ONE;
        }
        return str;
    }
}
