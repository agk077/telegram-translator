package ru.liga.translator.service.rule;

import org.junit.Before;
import org.junit.Test;
import ru.liga.translator.repository.DictionaryRuleFour;
import ru.liga.translator.service.translate.impl.rule.RuleFour;

import static org.junit.Assert.assertEquals;

public class RuleFourTest {

    RuleFour ruleFour;

    @Before
    public void setUp() {
        ruleFour = new RuleFour(new DictionaryRuleFour());
    }

    @Test
    public void translateNoChangeTest() {
        assertEquals(ruleFour.translate("синхрофазотрон"), "синхрофазотрон");
        assertEquals(ruleFour.translate("океюшки"), "океюшки");
    }

    @Test
    public void translateChangeTest() {
        assertEquals(ruleFour.translate("еда"), "ѣда");
        assertEquals(ruleFour.translate("лелеять"), "лелѣять");
    }
}