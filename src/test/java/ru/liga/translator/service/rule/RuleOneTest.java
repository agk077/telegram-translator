package ru.liga.translator.service.rule;

import org.junit.Before;
import org.junit.Test;
import ru.liga.translator.service.translate.impl.rule.RuleOne;

import static org.junit.Assert.assertEquals;

public class RuleOneTest {
    RuleOne ruleOne;

    @Before
    public void setUp() {
        ruleOne = new RuleOne();
    }

    @Test
    public void translateNoChangeTest() {
        assertEquals(ruleOne.translate("яма"), "яма");
        assertEquals(ruleOne.translate("май"), "май");
        assertEquals(ruleOne.translate("error"), "error");
        assertEquals(ruleOne.translate("моль"), "моль");
    }

    @Test
    public void translateChangeTest() {
        assertEquals(ruleOne.translate("стол"), "столъ");
        assertEquals(ruleOne.translate("май"), "май");
        assertEquals(ruleOne.translate("мяч"), "мячъ");

    }
}