package ru.liga.translator.service.translate.impl.rule;

import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RuleTwo {
    public static final String VOWELS = "аеёийоуэюяАЕЁИЙОУЭЮЯ";
    public static final char SEARCH_RULE_TWO = 'и';
    public static final char SWAP_RULE_TWO = 'і';
    private final Set<Character> vowels = VOWELS.chars()
            .mapToObj(chr -> (char) chr)
            .collect(Collectors.toSet());

    public String translate(String str) {
        char[] strArray = str.toCharArray();
        for (int i = 0; i < strArray.length - 1; i++) {
            if (strArray[i] == SEARCH_RULE_TWO && isVowels(strArray[i + 1])) {
                strArray[i] = SWAP_RULE_TWO;
            }
        }
        return String.valueOf(strArray);
    }

    private boolean isVowels(Character nextChar) {
        return vowels.contains(nextChar);
    }
}
