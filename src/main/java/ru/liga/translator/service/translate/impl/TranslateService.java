package ru.liga.translator.service.translate.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.liga.translator.service.translate.Translate;
import ru.liga.translator.service.translate.impl.rule.RuleFour;
import ru.liga.translator.service.translate.impl.rule.RuleOne;
import ru.liga.translator.service.translate.impl.rule.RuleThree;
import ru.liga.translator.service.translate.impl.rule.RuleTwo;

@Slf4j
@Service
@RequiredArgsConstructor
public class TranslateService implements Translate {
    private final RuleOne ruleOne;
    private final RuleTwo ruleTwo;
    private final RuleThree ruleThree;
    private final RuleFour ruleFour;

    @Override
    public String translate(String word) {
        String changeWord = ruleThree.translate(ruleTwo.translate(ruleOne.translate(ruleFour.translate(word))));
        log.info("Переводим слово '"+word+"' как '"+changeWord+"'");
        return changeWord;
    }
}
