package ru.liga.translator.service.rule;

import org.junit.Before;
import org.junit.Test;
import ru.liga.translator.service.translate.impl.rule.RuleTwo;

import static org.junit.Assert.assertEquals;

public class RuleTwoTest {
    RuleTwo ruleTwo;

    @Before
    public void setUp() {
        ruleTwo = new RuleTwo();
    }

    @Test
    public void translateNoChangeTest() {
        assertEquals(ruleTwo.translate("мираж"), "мираж");
        assertEquals(ruleTwo.translate("витрина"), "витрина");
    }

    @Test
    public void translateChangeTest() {
        assertEquals(ruleTwo.translate("линия"), "линія");
        assertEquals(ruleTwo.translate("синий"), "синій");
    }

}