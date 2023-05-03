package ru.liga.translator.service.rule;

import org.junit.Before;
import org.junit.Test;
import ru.liga.translator.repository.DictionaryRuleThree;
import ru.liga.translator.service.translate.impl.rule.RuleThree;

import static org.junit.Assert.assertEquals;

public class RuleThreeTest {
    RuleThree ruleThree;

    @Before
    public void setUp() {
        ruleThree = new RuleThree(new DictionaryRuleThree());
    }

    @Test
    public void translateNoChangeTest() {
        assertEquals(ruleThree.translate("Франческа"), "Франческа");
        assertEquals(ruleThree.translate("фиалка"), "фиалка");
    }

    @Test
    public void translateChangeTest() {
        assertEquals(ruleThree.translate("Агафья"), "Агаѳья");
        assertEquals(ruleThree.translate("Феофанъ"), "Ѳеофанъ");
    }

}